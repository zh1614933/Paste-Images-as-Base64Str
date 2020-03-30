package img2md;

import com.intellij.ide.util.PropertiesComponent;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.EditorModificationUtil;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.ui.DialogBuilder;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.openapi.vcs.AbstractVcs;
import com.intellij.openapi.vcs.ProjectLevelVcsManager;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import static img2md.ImageUtils.bufferImage2Base64String;
import static img2md.ImageUtils.getImageFromClipboard;
import static img2md.ImageUtils.makeRoundedCorner;
import static img2md.ImageUtils.save;
import static img2md.ImageUtils.scaleImage;
import static img2md.ImageUtils.toBufferedImage;
import static img2md.ImageUtils.whiteToTransparent;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Collections;
import java.util.UUID;
import javax.swing.JLabel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.jetbrains.annotations.NotNull;

public class PasteImageFromClipboard extends AnAction {


    private static final String DOC_BASE_NAME = "{document_name}";


    @Override
    public void actionPerformed(AnActionEvent e) {
        Image imageFromClipboard = getImageFromClipboard();

        // deterimine save path for the image
        Editor ed = e.getData(PlatformDataKeys.EDITOR);
        if (ed == null) {
           // FileEditorManager
            return;
        }


        if (imageFromClipboard == null) {
            DialogBuilder builder = new DialogBuilder();

            builder.setCenterPanel(new JLabel("Clipboard does not contain any image"));
            builder.setDimensionServiceKey("PasteImageFromClipboard.NoImage");
            builder.setTitle("No image in Clipboard");
            builder.removeAllActions();


            builder.addOkAction();

            builder.show();
            return;
        }


        // from http://stackoverflow.com/questions/17915688/intellij-plugin-get-code-from-current-open-file
        Document currentDoc = FileEditorManager.getInstance(ed.getProject()).getSelectedTextEditor().getDocument();
        VirtualFile currentFile = FileDocumentManager.getInstance().getFile(currentDoc);
        File curDocument = new File(currentFile.getPath());


        // add option to rescale image on the fly
        BufferedImage bufferedImage = toBufferedImage(imageFromClipboard);

        if (bufferedImage == null) {
            return;
        }

        Dimension dimension = new Dimension(bufferedImage.getWidth(), bufferedImage.getHeight());


        ImageInsertSettingsPanel insertSettingsPanel = showDialog(curDocument, dimension);

        if (insertSettingsPanel == null) {
            return;
        }

        String mode = insertSettingsPanel.getMode();

        if ("0".equals(mode)) {
            optionForSaveAsString(ed, bufferedImage);
        }
        else if ("1".equals(mode)) { //保存为文件
            optionForSaveAsFile(ed, insertSettingsPanel, bufferedImage);
        }
        else if ("2".equals(mode)) { //保存到云
            //TODO
            return;
        }
    }

    private void optionForSaveAsString(Editor ed, BufferedImage bufferedImage) {
        //bufferedImage  2  Base64String
        String bufferImage2Base64String = bufferImage2Base64String(bufferedImage);

        //生成唯一识别的序列号，用以区分不同图片
        String linkIdString = UUID.randomUUID().toString();

        //markdown中图片链接 ctrl + v 后粘贴后的内容 格式：  ![image][linkIdString]
        String addImageLink = "![image][" + linkIdString + "]";

        //markdown中 文章末尾的bufferImage2Base64String详细内容
        //格式  ： [linkIdString]:data:image/png;base64,bufferImage2Base64String
        String addImageContent = "[" + linkIdString +"]:data:image/png;base64," + bufferImage2Base64String;

        //将转换好的 图片链接插入光标
        insertImageElement(ed, "\n\n" +addImageLink + "\n\n");

        //得到当前光标所在位置
        int offsetAfterInsertImageElement = ed.getSelectionModel().getSelectionStart();

        //获取文本的总长度
        int documentTextLength = ed.getDocument().getTextLength();
        //移动光标  offset是相对于文件开头
        ed.getCaretModel().moveToOffset(documentTextLength);

        //将图片内容插入md末尾
        insertImageElement(ed, "\n\n" + addImageContent);

        //移动光标  offset是相对于文件开头
        ed.getCaretModel().moveToOffset(offsetAfterInsertImageElement);
    }
     /**
     * 作为文件保存
     * @param ed
     * @param insertSettingsPanel
     * @param bufferedImage
     */
    private void optionForSaveAsFile(Editor ed, ImageInsertSettingsPanel insertSettingsPanel, BufferedImage bufferedImage) {

        Document currentDoc = FileEditorManager.getInstance(ed.getProject()).getSelectedTextEditor().getDocument();
        VirtualFile currentFile = FileDocumentManager.getInstance().getFile(currentDoc);
        File curDocument = new File(currentFile.getPath());

        String imageName = insertSettingsPanel.getNameInput().getText();
        boolean whiteAsTransparent = insertSettingsPanel.getWhiteCheckbox().isSelected();
        boolean roundCorners = insertSettingsPanel.getRoundCheckbox().isSelected();
        double scalingFactor = ((Integer) insertSettingsPanel.getScaleSpinner().getValue()) * 0.01;


        if (whiteAsTransparent) {
            bufferedImage = toBufferedImage(whiteToTransparent(bufferedImage));
        }
//
        if (roundCorners) {
            bufferedImage = toBufferedImage(makeRoundedCorner(bufferedImage, 20));
        }

        if (scalingFactor != 1) {
            bufferedImage = scaleImage(bufferedImage,
                    (int) Math.round(bufferedImage.getWidth() * scalingFactor),
                    (int) Math.round(bufferedImage.getHeight() * scalingFactor));
        }

        // make selectable
//        File imageDir = new File(curDocument.getParent(), ".images");
        String mdBaseName = curDocument.getName().replace(".md", "").replace(".Rmd", "");

//        File imageDir = new File(curDocument.getParent(), "."+ mdBaseName +"_images");
        String dirPattern = insertSettingsPanel.getDirectoryField().getText();


        File imageDir = new File(curDocument.getParent(), dirPattern.replace(DOC_BASE_NAME, mdBaseName));


        if (!imageDir.exists() || !imageDir.isDirectory()) {
            imageDir.mkdirs();
        }


        File imageFile = new File(imageDir, imageName);

        // todo should we silently override the image if it is already present?
        save(bufferedImage, imageFile, "png");

//        PropertiesComponent.getInstance()

//        VirtualFile baseDir = e.getProject().getBaseDir();
//        final VirtualFile targetDir = baseDir.getFileSystem().findFileByPath(imageFile.getParentFile().getAbsolutePath());
//        if(targetDir != null) {
//            WriteCommandAction.runWriteCommandAction(e.getProject(), new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        targetDir.createChildData(this, imageFile.getName());
//                    } catch (IOException e1) {
//                        e1.printStackTrace();
//                    }
//                }
//            });
//        }

        // inject image element current markdown document
        insertImageElement(ed, curDocument.getParentFile().toPath().relativize(imageFile.toPath()).toFile());

        // https://intellij-support.jetbrains.com/hc/en-us/community/posts/206144389-Create-virtual-file-from-file-path
        VirtualFile fileByPath = LocalFileSystem.getInstance().refreshAndFindFileByIoFile(imageFile);
        assert fileByPath != null;

        AbstractVcs usedVcs = ProjectLevelVcsManager.getInstance(ed.getProject()).getVcsFor(fileByPath);
        if (usedVcs != null && usedVcs.getCheckinEnvironment() != null) {
            usedVcs.getCheckinEnvironment().scheduleUnversionedFilesForAddition(Collections.singletonList(fileByPath));
        }


        // update directory pattern preferences for file and globally
        PropertiesComponent.getInstance().setValue("PI__LAST_DIR_PATTERN", dirPattern);
        PropertiesComponent.getInstance().setValue("PI__DIR_PATTERN_FOR_" + currentFile.getPath(), dirPattern);
    }

    private void insertImageElement(final @NotNull Editor editor, File imageFile) {
        Runnable r = () -> EditorModificationUtil.insertStringAtCaret(editor, "![](" + imageFile.toString() + ")");

        WriteCommandAction.runWriteCommandAction(editor.getProject(), r);
    }

    /**
     *  向光标处插入内容
     * @param editor
     * @param insertString
     */
    private void insertImageElement(final @NotNull Editor editor, String insertString) {
        Runnable r = () -> EditorModificationUtil.insertStringAtCaret(editor, insertString);

        WriteCommandAction.runWriteCommandAction(editor.getProject(), r);
    }

    /**
     *  abc.java --> abc.png
     * @param src
     * @return
     */
    public  static  String getLimitFileName(String src){
        if(src==null) {
            return null;
        }
        String[] list =src.split("\\.");
        if(list.length==1) {
            return src;
        }
        list[list.length-1]="";
        return join(list,".");
    }
    public static  String join(String[] list, String conjunction)
    {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (String item : list)
        {
            if(item.equals("")) {
                continue;
            }
            if (first) {
                first = false;
            } else {
                sb.append(conjunction);
            }
            sb.append(item);
        }
        return sb.toString();
    }



    // for more examples see
//    http://www.programcreek.com/java-api-examples/index.php?api=com.intellij.openapi.ui.DialogWrapper
    private static ImageInsertSettingsPanel showDialog(File curDocument, Dimension imgDim) {
        DialogBuilder builder = new DialogBuilder();
        ImageInsertSettingsPanel contentPanel = new ImageInsertSettingsPanel();


        ChangeListener listener = new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                double scalingFactor = (Integer) contentPanel.getScaleSpinner().getValue() * 0.1;

                JLabel targetSizeLabel = contentPanel.getTargetSizeLabel();

                if (scalingFactor == 100) {
                    targetSizeLabel.setText(imgDim.getWidth() + " x " + imgDim.getHeight());

                } else {
                    long newWidth = Math.round(imgDim.getWidth() * scalingFactor);
                    long newHeight = Math.round(imgDim.getHeight() * scalingFactor);

                    targetSizeLabel.setText(newWidth + " x " + newHeight);
                }
            }
        };

        listener.stateChanged(null);
        contentPanel.getScaleSpinner().addChangeListener(listener);

        // restore directory pattern preferences for file and globally

        PropertiesComponent propComp = PropertiesComponent.getInstance();
        String dirPattern = propComp.getValue("PI__DIR_PATTERN_FOR_" + curDocument.getPath());
        if (dirPattern == null) {
            dirPattern = propComp.getValue("PI__LAST_DIR_PATTERN");
        }
        //if (dirPattern == null) dirPattern = "." + DOC_BASE_NAME + "_images";
        dirPattern = "." ;

        contentPanel.getDirectoryField().setText(dirPattern);

        //contentPanel.getNameInput().setText(UUID.randomUUID().toString().substring(0, 8));
        contentPanel.getNameInput().setText(getLimitFileName(curDocument.getName())+".png");

        builder.setCenterPanel(contentPanel);
        builder.setDimensionServiceKey("GrepConsoleSound");
        builder.setTitle("Paste Image Settings");
        builder.removeAllActions();

        builder.addOkAction();
        builder.addCancelAction();

        builder.setPreferredFocusComponent(contentPanel.getNameInput());

        boolean isOk = builder.show() == DialogWrapper.OK_EXIT_CODE;
        if (!isOk) {
            return null;
        }

        return contentPanel;
    }
}
