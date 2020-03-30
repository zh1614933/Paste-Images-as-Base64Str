/*
 * Created by JFormDesigner on Wed Jun 08 09:12:08 CEST 2016
 */

package img2md;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author unknown
 */
public class ImageInsertSettingsPanel extends JPanel implements ActionListener {
    private static final String SELECT_SAVE_AS_STRING = "SELECT_SAVE_AS_STRING";

    private static final String SELECT_SAVE_AS_FILE = "SELECT_SAVE_AS_FILE";

    private static final String SELECT_SAVE_AS_CLOUD = "SELECT_SAVE_AS_CLOUD";

    //mode :  0:string;1:file;2:cloud
    private String mode = "0";


    public ImageInsertSettingsPanel() {
        initComponents();
    }


    public JCheckBox getWhiteCheckbox() {
        return whiteCheckbox;
    }


    public JCheckBox getRoundCheckbox() {
        return roundCheckbox;
    }


    public JLabel getTargetSizeLabel() {
        return targetSizeLabel;
    }


    public JSpinner getScaleSpinner() {
        return scaleSpinner;
    }


    public JTextField getNameInput() {
        return nameInput;
    }


    public JTextField getDirectoryField() {
        return directoryField;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JLabel getLabel1() {
        return label1;
    }

    public void setLabel1(JLabel label1) {
        this.label1 = label1;
    }

    public void setNameInput(JTextField nameInput) {
        this.nameInput = nameInput;
    }

    public JLabel getLabel3() {
        return label3;
    }

    public void setLabel3(JLabel label3) {
        this.label3 = label3;
    }

    public void setDirectoryField(JTextField directoryField) {
        this.directoryField = directoryField;
    }

    public JPanel getPanel4() {
        return panel4;
    }

    public void setPanel4(JPanel panel4) {
        this.panel4 = panel4;
    }

    public void setWhiteCheckbox(JCheckBox whiteCheckbox) {
        this.whiteCheckbox = whiteCheckbox;
    }

    public void setRoundCheckbox(JCheckBox roundCheckbox) {
        this.roundCheckbox = roundCheckbox;
    }

    public JLabel getLabel4() {
        return label4;
    }

    public void setLabel4(JLabel label4) {
        this.label4 = label4;
    }

    public void setTargetSizeLabel(JLabel targetSizeLabel) {
        this.targetSizeLabel = targetSizeLabel;
    }

    public void setScaleSpinner(JSpinner scaleSpinner) {
        this.scaleSpinner = scaleSpinner;
    }

    public JLabel getLabel6() {
        return label6;
    }

    public void setLabel6(JLabel label6) {
        this.label6 = label6;
    }

    public JPanel getPanel2() {
        return panel2;
    }

    public void setPanel2(JPanel panel2) {
        this.panel2 = panel2;
    }

    public JLabel getLabel2() {
        return label2;
    }

    public void setLabel2(JLabel label2) {
        this.label2 = label2;
    }

    public JPanel getImageSaveModePanel() {
        return imageSaveModePanel;
    }

    public void setImageSaveModePanel(JPanel imageSaveModePanel) {
        this.imageSaveModePanel = imageSaveModePanel;
    }

    public ButtonGroup getSaveModeChoose() {
        return saveModeChoose;
    }

    public void setSaveModeChoose(ButtonGroup saveModeChoose) {
        this.saveModeChoose = saveModeChoose;
    }

    public JRadioButton getImage2SaveAsString() {
        return image2SaveAsString;
    }

    public void setImage2SaveAsString(JRadioButton image2SaveAsString) {
        this.image2SaveAsString = image2SaveAsString;
    }

    public JRadioButton getImage2SaveAsFile() {
        return image2SaveAsFile;
    }

    public void setImage2SaveAsFile(JRadioButton image2SaveAsFile) {
        this.image2SaveAsFile = image2SaveAsFile;
    }

    public JRadioButton getImage2SaveAsCloud() {
        return image2SaveAsCloud;
    }

    public void setImage2SaveAsCloud(JRadioButton image2SaveAsCloud) {
        this.image2SaveAsCloud = image2SaveAsCloud;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner non-commercial license
        panel1 = new JPanel();
        label1 = new JLabel();
        nameInput = new JTextField();
        label3 = new JLabel();
        directoryField = new JTextField();
        panel4 = new JPanel();
        whiteCheckbox = new JCheckBox();
        roundCheckbox = new JCheckBox();
        label4 = new JLabel();
        targetSizeLabel = new JLabel();
        scaleSpinner = new JSpinner();
        label6 = new JLabel();
        panel2 = new JPanel();
        label2 = new JLabel();


        //======== this ========
        setLayout(new GridBagLayout());
        ((GridBagLayout) getLayout()).columnWidths = new int[]{0, 0};
        ((GridBagLayout) getLayout()).rowHeights = new int[]{5, 0, 5, 0, 0};
        ((GridBagLayout) getLayout()).columnWeights = new double[]{1.0, 1.0E-4};
        ((GridBagLayout) getLayout()).rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0E-4};
        initImageSaveModePanel();
        //======== panel1 ========
        {
            panel1.setBorder(new TitledBorder("File Properties"));
            panel1.setLayout(new GridBagLayout());
            ((GridBagLayout) panel1.getLayout()).columnWidths = new int[]{0, 150, 0, 0};
            ((GridBagLayout) panel1.getLayout()).rowHeights = new int[]{0, 5, 5, 0};
            ((GridBagLayout) panel1.getLayout()).columnWeights = new double[]{0.0, 0.0, 1.0, 1.0E-4};
            ((GridBagLayout) panel1.getLayout()).rowWeights = new double[]{0.0, 0.0, 0.0, 1.0E-4};

            //---- label1 ----
            label1.setText("File Name");
            panel1.add(label1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                    new Insets(0, 0, 0, 0), 0, 0));
            panel1.add(nameInput, new GridBagConstraints(1, 0, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                    new Insets(0, 0, 0, 0), 0, 0));

            //---- label3 ----
            label3.setText("Directory Name");
            panel1.add(label3, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                    new Insets(0, 0, 0, 0), 0, 0));
            panel1.add(directoryField, new GridBagConstraints(1, 1, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                    new Insets(0, 0, 0, 0), 0, 0));
        }
        add(panel1, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 0, 0), 0, 0));

        //======== panel4 ========
        {
            panel4.setBorder(new TitledBorder("Image Properties"));
            panel4.setLayout(new GridBagLayout());
            ((GridBagLayout) panel4.getLayout()).columnWidths = new int[]{0, 0, 0, 0, 0};
            ((GridBagLayout) panel4.getLayout()).rowHeights = new int[]{0, 0, 0, 0};
            ((GridBagLayout) panel4.getLayout()).columnWeights = new double[]{1.0, 1.0, 1.0, 0.0, 1.0E-4};
            ((GridBagLayout) panel4.getLayout()).rowWeights = new double[]{0.0, 0.0, 0.0, 1.0E-4};

            //---- whiteCheckbox ----
            whiteCheckbox.setText("Convert white to transparent");
            whiteCheckbox.setSelected(true);
            panel4.add(whiteCheckbox, new GridBagConstraints(0, 0, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

            //---- roundCheckbox ----
            roundCheckbox.setText("Round corners");
            panel4.add(roundCheckbox, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

            //---- label4 ----
            label4.setText("Rescale Image");
            panel4.add(label4, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

            //---- targetSizeLabel ----
            targetSizeLabel.setText("text");
            panel4.add(targetSizeLabel, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

            //---- scaleSpinner ----
            scaleSpinner.setModel(new SpinnerNumberModel(100, 5, 200, 5));
            panel4.add(scaleSpinner, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

            //---- label6 ----
            label6.setText("%");
            panel4.add(label6, new GridBagConstraints(3, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
        }
        add(panel4, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

        //======== panel2 ========
        {
            panel2.setBorder(new TitledBorder("Markdown Properties"));
            panel2.setLayout(new GridBagLayout());
            ((GridBagLayout) panel2.getLayout()).columnWidths = new int[]{0, 0, 0};
            ((GridBagLayout) panel2.getLayout()).rowHeights = new int[]{0, 0};
            ((GridBagLayout) panel2.getLayout()).columnWeights = new double[]{0.0, 1.0, 1.0E-4};
            ((GridBagLayout) panel2.getLayout()).rowWeights = new double[]{0.0, 1.0E-4};

            //---- label2 ----
            label2.setText("None yet.");
            panel2.add(label2, new GridBagConstraints(0, 0, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }


    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner non-commercial license
    private JPanel panel1;
    private JLabel label1;
    private JTextField nameInput;
    private JLabel label3;
    private JTextField directoryField;
    private JPanel panel4;
    private JCheckBox whiteCheckbox;
    private JCheckBox roundCheckbox;
    private JLabel label4;
    private JLabel targetSizeLabel;
    private JSpinner scaleSpinner;
    private JLabel label6;
    private JPanel panel2;
    private JLabel label2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    //选择图片保存方式 面板
    private JPanel imageSaveModePanel;
    private ButtonGroup saveModeChoose;
    //保存为base64按钮
    private JRadioButton image2SaveAsString;
    //保存为文件按钮
    private JRadioButton image2SaveAsFile;
    //TODO 保存到云上的按钮
    private JRadioButton image2SaveAsCloud;

    private void initImageSaveModePanel() {
        imageSaveModePanel = new JPanel();
        {
            imageSaveModePanel.setBorder(new TitledBorder("Image Save Mode"));
            imageSaveModePanel.setLayout(new GridBagLayout());
            ((GridBagLayout) imageSaveModePanel.getLayout()).columnWidths = new int[]{0, 150, 0, 0};
            ((GridBagLayout) imageSaveModePanel.getLayout()).rowHeights = new int[]{0, 5, 5, 0};
            ((GridBagLayout) imageSaveModePanel.getLayout()).columnWeights = new double[]{0.0, 0.0, 1.0, 1.0E-4};
            ((GridBagLayout) imageSaveModePanel.getLayout()).rowWeights = new double[]{0.0, 0.0, 0.0, 1.0E-4};

            saveModeChoose = new ButtonGroup();
            image2SaveAsString = new JRadioButton("Save As String");
            image2SaveAsFile = new JRadioButton("Save As File", true);
            image2SaveAsCloud = new JRadioButton("Save As Cloud");
            saveModeChoose.add(image2SaveAsString);
            saveModeChoose.add(image2SaveAsFile);
            saveModeChoose.add(image2SaveAsCloud);

            imageSaveModePanel.add(image2SaveAsString);
            imageSaveModePanel.add(image2SaveAsFile);
            imageSaveModePanel.add(image2SaveAsCloud);

        }
        add(imageSaveModePanel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 0, 0), 0, 0));

        image2SaveAsString.addActionListener(this::actionPerformed);
        image2SaveAsString.setActionCommand(SELECT_SAVE_AS_STRING);

        image2SaveAsFile.addActionListener(this::actionPerformed);
        image2SaveAsFile.setActionCommand(SELECT_SAVE_AS_FILE);

        image2SaveAsCloud.addActionListener(this::actionPerformed);
        image2SaveAsCloud.setActionCommand(SELECT_SAVE_AS_CLOUD);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (SELECT_SAVE_AS_STRING.equals(e.getActionCommand())) {
            mode = "0";
            panel1.setVisible(true);
            label3.setVisible(false);
            directoryField.setVisible(false);
            panel2.setVisible(false);
            panel4.setVisible(false);
        }
        else if (SELECT_SAVE_AS_FILE.equals(e.getActionCommand())) {
            mode = "1";
            label3.setVisible(true);
            directoryField.setVisible(true);
            panel1.setVisible(true);
            panel2.setVisible(true);
            panel4.setVisible(true);
        }
        else if (SELECT_SAVE_AS_CLOUD.equals(e.getActionCommand())) {
            mode = "2";
            panel1.setVisible(false);
            panel2.setVisible(false);
            panel4.setVisible(false);
        }
     }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
}
