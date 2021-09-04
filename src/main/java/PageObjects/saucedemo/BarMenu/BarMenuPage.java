package PageObjects.saucedemo.BarMenu;


import PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BarMenuPage extends BasePage {
    private By reactBurgerMenuBtn = By.id("react-burger-menu-btn");

    public BarMenuPage(WebDriver driver) {
        super(driver);
    }

    public BarMenuPage clickBurgerMenu() {
        click(reactBurgerMenuBtn);
        return this;
    }

    public BarMenuPage clickLink(LinksEnum links) {
        click(links.getElement());
        return this;
    }
}
