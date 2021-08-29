package PageObjects.herokuapp;

import PageObjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    public By getExampleLink(String text) {
        return By.linkText(text);
    }

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage openPage() {
        open("http://the-internet.herokuapp.com/");
        return this;
    }

    public HomePage clickOnExample(ExampleLinksEnum exampleLink) {
        driver.findElement(getExampleLink(exampleLink.getExample())).click();
        return this;
    }

}
