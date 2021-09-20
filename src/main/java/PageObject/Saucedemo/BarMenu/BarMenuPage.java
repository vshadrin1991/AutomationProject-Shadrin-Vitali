package PageObject.Saucedemo.BarMenu;

import PageObject.BasePage;
import org.openqa.selenium.By;

public class BarMenuPage extends BasePage {
    private By reactBurgerMenuBtn = By.id("react-burger-menu-btn");

    public BarMenuPage clickBurgerMenu() {
        click(reactBurgerMenuBtn);
        return this;
    }

    public BarMenuPage clickLink(LinksEnum links) {
        click(links.getElement());
        return this;
    }
}
