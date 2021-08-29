package PageObjects.herokuapp;

import PageObjects.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ContextMenuPage extends BasePage {

    private By title = By.tagName("h3");
    private By hotSpot = By.id("hot-spot");

    public ContextMenuPage(WebDriver driver) {
        super(driver);
    }

    public ContextMenuPage verifyPageTitle() {
        Assert.assertEquals(driver.findElement(this.title).getText(), ExampleLinksEnum.CONTEXT_MENU.getExample());
        return this;
    }

    public ContextMenuPage clickBoxBelow() {
        actions.contextClick(driver.findElement(hotSpot)).perform();
        return this;
    }

    public ContextMenuPage checkAlertText() {
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("You selected a context menu", alert.getText(), "Click 'the-internet' menu item failed.");
        alert.accept();
        return this;
    }

}
