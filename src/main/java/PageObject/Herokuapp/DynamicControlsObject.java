package PageObject.Herokuapp;

import PageObject.Saucedemo.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static PageObject.Herokuapp.HomePageLinksEnum.DYNAMIC_CONTROLS;

public class DynamicControlsObject extends BasePage {
    private By removeBtn = By.cssSelector("#checkbox-example>button");
    private By textBack = By.cssSelector("#checkbox-example>p");
    private By title = By.tagName("h4");


    public DynamicControlsObject(WebDriver driver) {
        super(driver);
    }

    public DynamicControlsObject verifyPageTitle() {
        Assert.assertEquals(getElementText(title), DYNAMIC_CONTROLS.getLinkText());
        return this;
    }

    public DynamicControlsObject clickRemoveBtn() {
        click(removeBtn);
        return this;
    }

    public DynamicControlsObject verifyElementText(String text) {
        wait.until(ExpectedConditions.textToBe(textBack, text));
        return this;
    }

}
