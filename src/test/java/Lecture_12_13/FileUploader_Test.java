package Lecture_12_13;

import PageObject.Herokuapp.FileUploaderObject;
import PageObject.Herokuapp.HomePageLinksEnum;
import PageObject.Herokuapp.HomePageObject;
import driver.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FileUploader_Test extends BaseTest {
    HomePageObject homePageObject;
    FileUploaderObject fileUploaderObject;

    @BeforeClass
    public void precondition() {
        homePageObject = new HomePageObject(driver);
        fileUploaderObject = new FileUploaderObject(driver);
        homePageObject.clickLink(HomePageLinksEnum.FILE_UPLOADER);
    }

    @Test
    public void fileUploader_Test() {
        fileUploaderObject
                .verifyPageTitle("File Uploader")
                .uploadFile()
                .clickFileSubmit()
                .verifyPageTitle("File Uploaded!")
                .verifyThatFileUploaded("image.jpeg");
    }
}
