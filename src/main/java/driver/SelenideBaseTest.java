package driver;


import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import properties.PropertyReader;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.driver;

public class SelenideBaseTest {
    private PropertyReader propertyReader;

    @BeforeTest(alwaysRun = true)
    protected void startTest(ITestContext context) {
        this.propertyReader = new PropertyReader();
        this.propertyReader.setProperties(context.getSuite().getParameter("env") == null ?
                System.getProperties().getProperty("env") : context.getSuite().getParameter("env"));
    }

    protected <T> T get(Class<T> pageClass) {
        return driver().hasWebDriverStarted() ? page(pageClass) : open(propertyReader.getProperties().getProperty("url"), pageClass);
    }

    protected <T> T get(Class<T> pageClass, String url) {
        return driver().hasWebDriverStarted() ? page(pageClass) : open(url, pageClass);
    }
}
