package Lecture_10;

import PageObject.LoginPage;
import PageObject.ProductPage;
import driver.SetUpTearDown;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static driver.SetUpTearDown.driver;

@Listeners(SetUpTearDown.class)
public class Listener {
    LoginPage loginPage;
    ProductPage productPage;

    @BeforeClass
    public void preconditions() {
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
    }

    @BeforeMethod
    public void precondition() {
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
