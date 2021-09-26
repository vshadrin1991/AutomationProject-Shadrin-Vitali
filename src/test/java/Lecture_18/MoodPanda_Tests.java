package Lecture_18;

import SelenidePages.HomePage;
import SelenidePages.LoginPage;
import SelenidePages.NavigationPage;
import driver.SelenideBaseTest;
import org.testng.annotations.Test;

public class MoodPanda_Tests extends SelenideBaseTest {

    @Test
    public void checkHomePage_Test() {
        get(HomePage.class).verifyHomePage().clickScrollDown();
    }

    @Test
    public void checkLoginPage_Test() {
        get(NavigationPage.class).click("Login");
        get(LoginPage.class)
                .checkLoginPage()
                .enterEmail("test@test.com")
                .enterPassword("12321313")
                .clickLogin();
    }
}
