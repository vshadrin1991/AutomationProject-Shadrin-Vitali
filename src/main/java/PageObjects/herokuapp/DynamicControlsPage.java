package PageObjects.herokuapp;

import PageObjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class DynamicControlsPage extends BasePage {
    private By title = By.tagName("h4");
    private By checkbox = By.id("checkbox");
    private By input = By.cssSelector("[type=text]");
    private By removeButton = By.xpath("//form[@id='checkbox-example']//button");
    private By removeTxt = By.xpath("//form[@id='checkbox-example']//p");
    private By enableButton = By.xpath("//form[@id='input-example']//button");

    public DynamicControlsPage(WebDriver driver) {
        super(driver);
    }

    public DynamicControlsPage verifyPageTitle() {
        Assert.assertEquals(driver.findElement(this.title).getText(), ExampleLinksEnum.DYNAMIC_CONTROLS.getExample());
        return this;
    }

    public DynamicControlsPage verifyClickOnCheckbox() {
        find(checkbox).click();
        find(removeButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(removeTxt));
        Assert.assertEquals(getElementText(removeTxt), "It's gone!");
        return this;
    }
}
