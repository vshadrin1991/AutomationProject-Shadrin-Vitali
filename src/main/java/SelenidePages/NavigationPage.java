package SelenidePages;

import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class NavigationPage {

    SelenideElement getLink(NavigationEnum navigationEnum) {
        return $(By.linkText(navigationEnum.getMenu()));
    }

    public NavigationPage click(NavigationEnum navigationEnum) {
        log.info("Click on link :: " + navigationEnum);
        getLink(navigationEnum).click();
        return this;
    }
}
