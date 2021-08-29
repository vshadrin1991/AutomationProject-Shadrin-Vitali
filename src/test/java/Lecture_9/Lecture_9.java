package Lecture_9;

import PageObjects.saucedemo.LoginPage;
import PageObjects.saucedemo.ProductPage;
import driver.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Lecture_9 extends BaseTest {
    LoginPage loginPage;
    ProductPage productPage;

    @BeforeMethod
    public void precondition() {
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        loginPage.openPage();
    }

    @Test(priority = 1)
    public void loginToApplicationStandard_Test() {
        loginPage.openPage()
                .verifyLoginPage()
                .loginToApplication("standard_user", "secret_sauce");
        productPage.verifyProductPage();
    }

    @Test(priority = 2)
    public void loginToApplicationProblem_Test() {
        loginPage.openPage()
                .verifyLoginPage()
                .loginToApplication("problem_user", "secret_sauce");
        productPage.verifyProductPage();
    }
}
