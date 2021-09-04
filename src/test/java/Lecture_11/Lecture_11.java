package Lecture_11;

import PageObject.BarMenu.BarMenuPage;
import PageObject.BarMenu.LinksEnum;
import PageObject.LoginPage;
import PageObject.ProductPage;
import driver.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Lecture_11 extends BaseTest {
    LoginPage loginPage;
    ProductPage productPage;
    BarMenuPage barMenuPage;

    @BeforeClass
    public void precondition() {
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        barMenuPage = new BarMenuPage(driver);
        loginPage.openPage();
    }

    @Parameters({"username", "password", "error"})
    @Description("Login to application with standard user")
    @Step("Login to application with standard user")
    @Test(priority = 1)
    public void loginToApplicationStandard_Test(@Optional("standard_user") String username, @Optional("secret_sauce") String password, @Optional("") String error) {
        loginPage.openPage()
                .verifyLoginPage()
                .loginToApplication(username, password);
        productPage.verifyProductPage();
        barMenuPage
                .clickBurgerMenu()
                .clickLink(LinksEnum.logout);

    }

    @Description("Login to application with problem user")
    @Step("Login to application with problem user")
    @Link("https://docs.qameta.io/allure/#_test_execution")
    @Issue("COVID-19")
    @TmsLink("COVID-19")
    @Test(priority = 2)
    public void loginToApplicationProblem_Test() {
        loginPage.openPage()
                .verifyLoginPage()
                .loginToApplication("problem_user", "secret_sauce");
        productPage.verifyProductPage();
    }
}