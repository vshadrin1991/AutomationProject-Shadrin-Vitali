package Lecture_11;

import PageObject.BarMenu.BarMenuPage;
import PageObject.LoginPage;
import PageObject.ProductPage;
import driver.BaseTest;
import driver.Listener;
import org.testng.annotations.*;

import static PageObject.BarMenu.LinksEnum.logout;

@Listeners(Listener.class)
public class Lecture_11 extends BaseTest {

    LoginPage loginPage = new LoginPage(driver);
    ProductPage productPage = new ProductPage(driver);
    BarMenuPage barMenuPage = new BarMenuPage(driver);

    @BeforeClass
    public void precondition() {
        loginPage.openPage();
    }

    @Parameters({"username", "password", "error"})
    //@Test(priority = 1)
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

    @Test(priority = 2)
    public void clickLink_Test() {
        barMenuPage
                .clickBurgerMenu()
                .clickLink(logout);
    }
}
