package Lecture_12_13;

import PageObject.Herokuapp.FileUploaderObject;
import PageObject.Herokuapp.HomePageLinksEnum;
import PageObject.Herokuapp.HomePageObject;
import driver.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FileUploader_Test extends BaseTest {
    FileUploaderObject fileUploaderObject;

    @BeforeClass
    public void precondition() {
        fileUploaderObject = new FileUploaderObject(driver);
    }

    @Test
    public void fileUploader_Test() {
        HomePageObject homePageObject = new HomePageObject(driver);
        homePageObject.clickLink(HomePageLinksEnum.FILE_UPLOADER);
        fileUploaderObject
                .verifyPageTitle("File Uploader")
                .dragDropUpload("image.jpeg");
        //.uploadFile()
        //.clickFileSubmit()
        //.verifyPageTitle("File Uploaded!")
        //.verifyThatFileUploaded("image.jpeg");
    }
}
