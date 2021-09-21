package PageObject.Saucedemo;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class ProductPage extends BasePage {
    private By title = By.cssSelector("[class=title]");
    private By logo = By.cssSelector("[class=app_logo]");
    private By filter = By.tagName("select");
    private By products = By.cssSelector(".inventory_item_name");

    public ProductPage verifyProductPage() {
        isDisplayed(title, logo, filter);
        return this;
    }

    public ProductPage verifyProductsListSorted() {
        List<String> expectedData = driver.findElements(products).stream().map(data -> data.getText()).sorted().collect(Collectors.toList());
        List<String> actualData = driver.findElements(products).stream().map(data -> data.getText()).collect(Collectors.toList());
        Assert.assertEquals(expectedData, actualData);
        return this;
    }
}
