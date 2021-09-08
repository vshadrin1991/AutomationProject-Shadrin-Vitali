package Lecture_12;

import PageObject.Herokuapp.ContextMenuObject;
import PageObject.Herokuapp.HomePageObject;
import driver.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static PageObject.Herokuapp.HomePageLinksEnum.CONTEXT_MENU;

public class ContextMenu_Test extends BaseTest {
    ContextMenuObject contextMenuObject;
    HomePageObject homePageObject;

    @BeforeClass
    public void precondition() {
        contextMenuObject = new ContextMenuObject(driver);
        homePageObject = new HomePageObject(driver);
        homePageObject.clickLink(CONTEXT_MENU);
    }

    @Test
    public void contextMenuObject_Test() {
        contextMenuObject
                .verifyPageTitle()
                .verifyAlertText();
    }

}
