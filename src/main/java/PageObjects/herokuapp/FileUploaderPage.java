package PageObjects.herokuapp;

import PageObjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class FileUploaderPage extends BasePage {

    private By fileUpload = By.id("file-upload");
    private By fileSubmit = By.id("file-submit");
    private By uploadedFiles = By.id("uploaded-files");
    private By dragDropUpload = By.id("drag-drop-upload");
    private By filename = By.cssSelector(".dz-started .dz-filename");
    private String userDir = System.getProperty("user.dir") + "\\src\\test\\resources\\";

    public FileUploaderPage(WebDriver driver) {
        super(driver);
    }

    public FileUploaderPage uploadFile(String fileName) {
        driver.findElement(fileUpload).sendKeys(userDir + fileName);
        return this;
    }

    public FileUploaderPage dragUploadFile(String fileName) {
        click(dragDropUpload);
        StringSelection stringSelection = new StringSelection(userDir + fileName);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (AWTException e) {
            e.printStackTrace();
        }
        return this;
    }

    public FileUploaderPage verifyFileUpload(String fileName) {
        Assert.assertEquals(getElementText(this.filename), fileName);
        return this;
    }

    public FileUploaderPage clickFileSubmit() {
        click(fileSubmit);
        return this;
    }

    public FileUploaderPage verifyFileUploaded(String fileName) {
        Assert.assertEquals(getElementText(uploadedFiles), fileName);
        return this;
    }
}
