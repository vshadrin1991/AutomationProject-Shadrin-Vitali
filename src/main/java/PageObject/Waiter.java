package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiter extends WebDriverWait {

    public Waiter(WebDriver driver) {
        super(driver, 20);
    }

    public void waitForClickable(WebElement element) {
        this.until(ExpectedConditions.elementToBeClickable(element));
    }
}
