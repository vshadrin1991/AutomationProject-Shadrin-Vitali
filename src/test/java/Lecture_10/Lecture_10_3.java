package Lecture_10;

import PageObject.LoginPage;
import PageObject.ProductPage;
import driver.BaseTest;
import driver.Listener;
import driver.Retry;
import org.testng.annotations.*;

@Listeners({Listener.class})
public class Lecture_10_3 extends BaseTest {
    LoginPage loginPage = new LoginPage(driver);
    ProductPage productPage = new ProductPage(driver);

    @BeforeMethod
    public void precondition() {
        loginPage.openPage();
    }

    @Parameters({"username", "password", "error"})
    @Test(priority = 1, retryAnalyzer = Retry.class)
    public void loginToApplicationStandard_Test(@Optional("standard_user") String username, @Optional("secret_sauce") String password, @Optional("") String error) {
        loginPage.openPage()
                .verifyLoginPage()
                .loginToApplication(username, password);
        if (error.isEmpty()) {
            productPage.verifyProductPage();
        } else {
            loginPage.checkErrorText(error);
        }
    }
}
