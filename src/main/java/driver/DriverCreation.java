package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import properties.PropertyReader;
/*
    Patten Singleton
 */

public class DriverCreation {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void setDriver(String browserType, PropertyReader propertyReader) {
        if (driver.get() == null) {
            createDriver(browserType, propertyReader);
        }
    }

    public static void createDriver(String browserType, PropertyReader propertyReader) {
        switch (browserType) {
            case "CHROME":
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments(propertyReader.getProperties().getProperty("chrome.browser.arguments").split(":"));
                driver.set(new ChromeDriver(options));
                break;
            case "FIREFOX":
                WebDriverManager.firefoxdriver().setup();
                break;
            case "IE":
                WebDriverManager.iedriver().setup();
                break;
        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().close();
            driver.get().quit();
            driver.remove();
        }
    }
}
