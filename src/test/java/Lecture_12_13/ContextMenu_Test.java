package Lecture_12_13;

import PageObject.Herokuapp.ContextMenuObject;
import PageObject.Herokuapp.HomePageLinksEnum;
import PageObject.Herokuapp.HomePageObject;
import driver.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static PageObject.Herokuapp.HomePageLinksEnum.CONTEXT_MENU;

public class ContextMenu_Test extends BaseTest {
    ContextMenuObject contextMenuObject;

    @BeforeClass
    public void precondition() {
        contextMenuObject = new ContextMenuObject(driver);
    }

    @Test
    public void contextMenuObject_Test() {
        HomePageObject homePageObject =  new HomePageObject(driver);
        homePageObject.clickLink(HomePageLinksEnum.CONTEXT_MENU);
        contextMenuObject
                .verifyPageTitle()
                .verifyAlertText();
    }

}
