package Lecture_12;


import PageObjects.herokuapp.*;
import driver.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static PageObjects.herokuapp.ExampleLinksEnum.*;

public class Lecture_12 extends BaseTest {
    HomePage homePage;
    ContextMenuPage contextMenuPage;
    DynamicControlsPage dynamicControlsPage;
    FileUploaderPage fileUploaderPage;
    FramesPage framesPage;
    DownloaderPage downloaderPage;

    @BeforeClass
    public void initialization() {
        homePage = new HomePage(driver);
        contextMenuPage = new ContextMenuPage(driver);
        dynamicControlsPage = new DynamicControlsPage(driver);
        fileUploaderPage = new FileUploaderPage(driver);
        framesPage = new FramesPage(driver);
        downloaderPage = new DownloaderPage(driver);
    }

    @BeforeMethod
    public void precondition() {
        homePage.openPage();
    }

    @Test(priority = 1)
    public void contextMenu_Test() {
        homePage.clickOnExample(CONTEXT_MENU);
        contextMenuPage
                .verifyPageTitle()
                .clickBoxBelow()
                .checkAlertText();
    }

    @Test(priority = 2)
    public void dynamicControls_Test() {
        homePage.clickOnExample(DYNAMIC_CONTROLS);
        dynamicControlsPage.verifyPageTitle().verifyClickOnCheckbox();
    }

    @Test(priority = 3)
    public void fileUploader_Test() {
        homePage.clickOnExample(FILE_UPLOAD);
        fileUploaderPage
                //.dragUploadFile("hello-world.jpg")
                //.verifyFileUpload("hello-world.jpg")
                .uploadFile("hello-world.jpg")
                .clickFileSubmit()
                .verifyFileUploaded("hello-world.jpg");
    }

    @Test(priority = 4)
    public void framePage_Test() {
        homePage.clickOnExample(FRAMES);
        framesPage
                .clickFrameLink(FramesPage.Frame.iFrame)
                .verifyFrameText("Your content goes here.");
    }

    @Test(priority = 5)
    public void downloaderPage_Test() {
        homePage.clickOnExample(FILE_DOWNLOAD);
        downloaderPage
                .downloadFile("28.jpg")
                .checkFileDownload("28.jpg");
    }
}
