package PageObjects.saucedemo;

import PageObjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {
    private By title = By.cssSelector("[class=title]");
    private By logo = By.cssSelector("[class=app_logo]");
    private By filter = By.tagName("select");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage verifyProductPage() {
        isDisplayed(title, logo, filter);
        return this;
    }
}
