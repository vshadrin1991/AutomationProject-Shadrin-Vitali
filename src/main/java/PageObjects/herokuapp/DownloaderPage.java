package PageObjects.herokuapp;

import PageObjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.File;

public class DownloaderPage extends BasePage {
    private By getDownloadFile(String text) {
        return By.partialLinkText(text);
    }

    public DownloaderPage(WebDriver driver) {
        super(driver);
    }

    public DownloaderPage downloadFile(String fileName) {
        click(getDownloadFile(fileName));
        return this;
    }

    public DownloaderPage checkFileDownload(String fileName) {
        String home = System.getProperty("user.home");
        File file = new File(home + "/Downloads/" + fileName);
        pause(2);
        Assert.assertTrue(file.exists());
        return this;
    }
}
