package SelenidePages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {
    @FindBy(how = How.ID, using = "page-top")
    SelenideElement pageTop;

    @FindBy(how = How.CSS, using = ".intro-content")
    SelenideElement introContent;

    @FindBy(how = How.CSS, using = ".scroll-down > .btn.page-scroll")
    SelenideElement scrollDown;

    public HomePage verifyHomePage() {
        pageTop.should(Condition.exist);
        introContent.should(Condition.exist);
        return this;
    }

    public HomePage clickScrollDown() {
        scrollDown.click();
        return this;
    }
}
