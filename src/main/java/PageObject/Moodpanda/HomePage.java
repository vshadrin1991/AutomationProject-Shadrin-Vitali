package PageObject.Moodpanda;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    @FindBy(css = ".scroll-down > a")
    SelenideElement scrollDownBtn;

    @FindBy(className = "brand-name-subtext")
    SelenideElement brandNameSubtext;

    @FindBy(css = ".img-responsive.img-centered")
    SelenideElement img;

    SelenideElement titleElement(Titles titles) {
        return $(By.xpath("//li//a[contains(text(), '" + titles.getTitle() + "')]"));
    }

    public HomePage clickScrollDownBtn() {
        scrollDownBtn.click();
        return this;
    }

    public HomePage checkBrandNameSubtext() {
        brandNameSubtext.should(Condition.matchText("track your mood & get anonymous support"));
        return this;
    }

    public HomePage checkImage() {
        this.img.shouldBe(Condition.exist);
        return this;
    }

    public HomePage clickTitle(Titles titles) {
        this.titleElement(titles).click();
        return this;
    }
}
