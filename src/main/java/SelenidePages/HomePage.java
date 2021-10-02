package SelenidePages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public class HomePage {
    @FindBy(how = How.ID, using = "page-top")
    SelenideElement pageTop;

    @FindBy(how = How.CSS, using = ".intro-content")
    SelenideElement introContent;

    @FindBy(how = How.CSS, using = ".scroll-down > .btn.page-scroll")
    SelenideElement scrollDown;

    @FindBy(css = ".about-content h3")
    ElementsCollection aboutContent;

    public HomePage verifyHomePage() {
        pageTop.should(Condition.exist);
        introContent.should(Condition.exist);
        return this;
    }

    public HomePage clickScrollDown() {
        scrollDown.click();
        return this;
    }

    public List<String> getAboutContent() {
        return new ArrayList<>() {{
            addAll(aboutContent.stream().map(el -> el.shouldNotBe(Condition.empty).getText()).collect(Collectors.toList()));
        }};
    }
}
