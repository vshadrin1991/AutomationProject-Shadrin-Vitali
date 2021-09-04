package PageObjects.saucedemo.BarMenu;

import org.openqa.selenium.By;

public enum LinksEnum {
    logout(By.id("logout_sidebar_link")),
    inventory(By.id("inventory_sidebar_link")),
    about(By.id("about_sidebar_link")),
    reset(By.id("reset_sidebar_link"));

    private By element;

    LinksEnum(By element) {
        this.element = element;
    }

    public By getElement() {
        return element;
    }
}
