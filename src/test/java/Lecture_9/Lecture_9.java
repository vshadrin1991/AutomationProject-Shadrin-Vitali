package Lecture_9;

import PageFactory.LoginPage;
import driver.DriverExecutor;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Lecture_9 extends DriverExecutor {
    PageObjects.LoginPage loginPage;
    LoginPage loginPageAnnotations;

    @BeforeTest
    public void preconditions() {
        loginPage = new PageObjects.LoginPage(driver);
        loginPageAnnotations = new LoginPage(driver);
    }

    @Test
    public void test1() {
        loginPage
                .openPage()
                .clickLoginBtn()
                .fillAuthFields("123", "123")
                .enterLogin("123")
                .enterPassword("123")
                .clickLoginBtn();
    }

    @Test
    public void test2() {
        loginPageAnnotations
                .openPage()
                .fillAuthFields("123", "123");
    }
}
