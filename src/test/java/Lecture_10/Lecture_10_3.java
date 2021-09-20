package Lecture_10;

import PageObject.Saucedemo.LoginPage;
import PageObject.Saucedemo.ProductPage;
import driver.DriverCreation;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import testng.Listener;

@Listeners({Listener.class})
public class Lecture_10_3 {

    @DataProvider(name = "user data", parallel = true)
    public Object[][] data() {
        return new Object[][]{
                {"standard_user", "secret_sauce", ""},
                {"", "", "Epic sadface: Username is required"}
        };
    }

    @Test(dataProvider = "user data")
    public void loginToApplicationStandard_Test(String username, String password, String error) {
        LoginPage loginPage = new LoginPage();
        ProductPage productPage = new ProductPage();
        loginPage.openPage()
                .verifyLoginPage()
                .loginToApplication(username, password);
        if (error.isEmpty()) {
            productPage.verifyProductPage();
        } else {
            loginPage.checkErrorText(error);
        }
    }

    @AfterMethod
    public void post() {
        DriverCreation.quitDriver();
    }
}
