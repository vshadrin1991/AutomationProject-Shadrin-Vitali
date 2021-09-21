package Lecture_10;

import PageObject.Saucedemo.LoginPage;
import PageObject.Saucedemo.ProductPage;
import driver.BaseTest;
import driver.DriverCreation;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
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
        WebDriver driver = DriverCreation.getDriver();
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
