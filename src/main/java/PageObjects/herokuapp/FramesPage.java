package PageObjects.herokuapp;

import PageObjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class FramesPage extends BasePage {
    private By getFrame(Frame frame) {
        return By.partialLinkText(frame.getFrame());
    }

    private By frameId = By.id("mce_0_ifr");
    private By textArea = By.cssSelector("#tinymce > p");

    public FramesPage(WebDriver driver) {
        super(driver);
    }

    public enum Frame {
        iFrame("iFrame"),
        NestedFrames("Nested Frames");
        String frame;

        Frame(String frame) {
            this.frame = frame;
        }

        public String getFrame() {
            return frame;
        }
    }

    public FramesPage clickFrameLink(Frame frame) {
        click(getFrame(frame));
        return this;
    }

    public FramesPage verifyFrameText(String expectedText) {
        switchToFrame(frameId);
        Assert.assertEquals(getElementText(textArea), expectedText);
        return this;
    }


}
