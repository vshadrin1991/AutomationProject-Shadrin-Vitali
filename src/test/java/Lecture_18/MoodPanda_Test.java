package Lecture_18;

import PageObject.Moodpanda.HomePage;
import PageObject.Moodpanda.TestimonialsPage;
import driver.BaseTestSelenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class MoodPanda_Test extends BaseTestSelenide {

    @Test
    public void verifyHomePage_Test(){
        get(HomePage.class)
                .checkBrandNameSubtext()
                .checkImage();
    }

    @Test
    public void verifyTestimonialsPage_Test() {
        get(HomePage.class)
                .clickScrollDownBtn();

        get(TestimonialsPage.class)
                .verifyContentText("FOR MOOD-TRACKING")
                .verifyContentText("MOBILE & WEB APP");
    }

    @AfterMethod
    public void post() {
        closeWebDriver();
    }
}
