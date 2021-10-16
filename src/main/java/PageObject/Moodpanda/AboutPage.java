package PageObject.Moodpanda;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.matchText;

public class AboutPage {
    @FindBy(xpath = "//*[@id='main']/div")
    SelenideElement aboutContainer;

    public AboutPage verifyAboutPage(String text) {
        aboutContainer.shouldBe(matchText(text));
        return this;
    }

}
