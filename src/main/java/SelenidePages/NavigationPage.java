package SelenidePages;

import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class NavigationPage {

    SelenideElement getLink(String text) {
        return $(By.linkText(text));
    }

    public NavigationPage click(String text) {
        log.info("Click on link :: " + text);
        getLink(text).click();
        return this;
    }
}
