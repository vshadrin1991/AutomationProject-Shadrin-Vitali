package PageObject;

import org.openqa.selenium.*;

import java.util.List;

public class UIElement implements WebElement {
    private final WebDriver driver;
    private final Waiter waiter;
    private final WebElement webElement;

    public UIElement(WebDriver driver, WebElement webElement) {
        this.driver = driver;
        this.webElement = webElement;
        this.waiter = new Waiter(driver);
    }

    @Override
    public void click() {
        try {
            webElement.click();
        } catch (ElementNotVisibleException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElement);
            waiter.waitForClickable(webElement);
            webElement.click();
        }
    }

    @Override
    public void submit() {

    }

    @Override
    public void sendKeys(CharSequence... charSequences) {

    }

    @Override
    public void clear() {

    }

    @Override
    public String getTagName() {
        return null;
    }

    @Override
    public String getAttribute(String s) {
        return null;
    }

    @Override
    public boolean isSelected() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public String getText() {
        return null;
    }

    @Override
    public List<WebElement> findElements(By by) {
        return null;
    }

    @Override
    public WebElement findElement(By by) {
        return null;
    }

    @Override
    public boolean isDisplayed() {
        return false;
    }

    @Override
    public Point getLocation() {
        return null;
    }

    @Override
    public Dimension getSize() {
        return null;
    }

    @Override
    public Rectangle getRect() {
        return null;
    }

    @Override
    public String getCssValue(String s) {
        return null;
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return null;
    }
}
