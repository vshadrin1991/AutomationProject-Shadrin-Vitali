package Lecture_18;

import SelenidePages.HomePage;
import SelenidePages.LoginPage;
import SelenidePages.NavigationPage;
import driver.SelenideBaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static SelenidePages.NavigationEnum.LOGIN;
import static SelenidePages.NavigationEnum.OVERVIEW;
import static com.codeborne.selenide.Selenide.closeWebDriver;

public class MoodPanda_Tests extends SelenideBaseTest {

    @Test(priority = 1)
    public void checkHomePage_Test() {
        get(HomePage.class)
                .verifyHomePage()
                .clickScrollDown();
    }

    @Test(priority = 2)
    public void checkLoginPage_Test() {
        get(NavigationPage.class).click(LOGIN);
        get(LoginPage.class)
                .checkLoginPage()
                .enterEmail("test@test.com")
                .enterPassword("12321313")
                .clickLogin();
        closeWebDriver();
    }

    @Test(priority = 3)
    public void checkOverview_Test() {
        get(NavigationPage.class).click(OVERVIEW);
        Assert.assertTrue(get(HomePage.class).getAboutContent().contains("LOVING COMMUNITY"));
    }
}
