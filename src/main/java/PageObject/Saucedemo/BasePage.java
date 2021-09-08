package PageObject.Saucedemo;

import driver.DriverCreation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePage {
    protected WebDriver driver = DriverCreation.getDriver();
    protected WebDriverWait wait = new WebDriverWait(DriverCreation.getDriver(), 5);
    protected Actions actions = new Actions(DriverCreation.getDriver());

    protected BasePage(WebDriver driver) {
        //this.driver = driver;
    }

    protected void enter(By element, CharSequence... charSequences) {
        driver.findElement(element).clear();
        driver.findElement(element).sendKeys(charSequences);
    }

    protected void click(By element) {
        driver.findElement(element).click();
    }

    protected void open(String url) {
        driver.get(url);
    }

    protected String getElementText(By element) {
        return driver.findElement(element).getText();
    }

    protected Integer getCountElements(By element) {
        return driver.findElements(element).size();
    }

    protected void isDisplayed(By... elements) {
        for (By element : elements) {
            Assert.assertFalse(driver.findElements(element).isEmpty(), "Element :: " + elements + " is not exist.");
        }
    }

    public void pause(Integer seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}