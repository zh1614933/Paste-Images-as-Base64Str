package test;

import org.jetbrains.annotations.TestOnly;
//import org.testng.annotations.Test;

import static img2md.PasteImageFromClipboard.getLimitFileName;

/**
 * pasteimages
 *
 * Created by yu on 2018/3/9.
 */
public class StringSimTest {



    @TestOnly
//    @Test
    public void SfeSTest(){
       assert  "abc".equals( getLimitFileName("abc.java").trim());
    }
}
