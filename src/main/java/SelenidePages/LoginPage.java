package SelenidePages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.Arrays;

import static properties.PropertyReader.getProperties;

@Log4j2
public class LoginPage extends SelenideBasePage<LoginPage> {

    @FindBy(id = "ContentPlaceHolderContent_ButtonLogin")
    SelenideElement loginBtn;

    @FindBy(id = "ContentPlaceHolderContent_TextBoxEmail")
    SelenideElement email;

    @FindBy(id = "ContentPlaceHolderContent_TextBoxPassword")
    SelenideElement password;

    @FindBy(id = "ContentPlaceHolderContent_HyperLinkRegister")
    SelenideElement createAccountBtn;


    public LoginPage checkLoginPage() {
        Assert.assertEquals(WebDriverRunner.getWebDriver().getCurrentUrl(), getProperties().getProperty("url") + "/Login/");
        Arrays.asList(loginBtn, email, password, createAccountBtn).forEach(el ->
                el.shouldBe(Condition.exist)
        );
        return me();
    }

    public LoginPage enterEmail(String email) {
        this.email.sendKeys(email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        this.password.sendKeys(password);
        return this;
    }

    public LoginPage clickLogin() {
        loginBtn.click();
        return this;
    }

    public LoginPage clickCrated() {
        createAccountBtn.click();
        return this;
    }
}
