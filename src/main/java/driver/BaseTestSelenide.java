package driver;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.driver;

public class BaseTestSelenide {

    public <PageObjectClass> PageObjectClass get(Class<PageObjectClass> pageObjectClassClass) {
        return driver().hasWebDriverStarted() ? page(pageObjectClassClass) : open("https://moodpanda.com/", pageObjectClassClass);
    }
}
