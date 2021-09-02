package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static driver.DriverCreation.getDriver;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected void enter(By element, CharSequence... charSequences) {
        getDriver().findElement(element).clear();
        getDriver().findElement(element).sendKeys(charSequences);
    }

    protected void click(By element) {
        getDriver().findElement(element).click();
    }

    protected void open(String url) {
        getDriver().get(url);
    }

    protected String getElementText(By element) {
        return getDriver().findElement(element).getText();
    }

    protected Integer getCountElements(By element) {
        return getDriver().findElements(element).size();
    }

    protected void isDisplayed(By... elements) {
        for (By element : elements) {
            Assert.assertTrue(getDriver().findElement(element).isDisplayed(), "Element :: " + elements + " is not exist.");
        }
    }

}
