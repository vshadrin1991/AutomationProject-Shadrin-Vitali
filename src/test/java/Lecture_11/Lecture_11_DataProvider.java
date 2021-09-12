package Lecture_11;

import PageObject.Saucedemo.LoginPage;
import PageObject.Saucedemo.ProductPage;
import PageObject.Saucedemo.User;
import driver.DriverCreation;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import testng.Listener;

@Listeners(Listener.class)
public class Lecture_11_DataProvider {

    @DataProvider(parallel = true, name = "data")
    public Object[][] dataProvider() {
        return new Object[][]{
                {new User("locked_out_user", "secret_sauce"), "Epic sadface: Sorry, this user has been locked out."},
                {new User("standard_user", "secret_sauce"), ""},
                {new User("problem_user", "secret_sauce"), ""},
                {new User("", ""), "Epic sadface: Username is required"}
        };
    }

    @Test(dataProvider = "data")
    public void loginToApplicationStandard_Test(User user, String error) {
        WebDriver driver = DriverCreation.getDriver();
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = new ProductPage(driver);
        loginPage.openPage()
                .verifyLoginPage()
                .loginToApplication(user);
        if (error.isEmpty()) {
            productPage.verifyProductPage();
        } else {
            loginPage.checkErrorText(error);
        }
    }

    @AfterMethod
    public void closeDriver() {
        DriverCreation.quitDriver();
    }
}
