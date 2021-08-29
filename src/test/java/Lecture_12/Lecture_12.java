package Lecture_12;


import PageObjects.herokuapp.ContextMenuPage;
import PageObjects.herokuapp.DynamicControlsPage;
import PageObjects.herokuapp.HomePage;
import driver.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static PageObjects.herokuapp.ExampleLinksEnum.*;

public class Lecture_12 extends BaseTest {
    HomePage homePage;
    ContextMenuPage contextMenuPage;
    DynamicControlsPage dynamicControlsPage;

    @BeforeClass
    public void initialization() {
        homePage = new HomePage(driver);
        contextMenuPage = new ContextMenuPage(driver);
        dynamicControlsPage = new DynamicControlsPage(driver);
    }

    @BeforeMethod
    public void precondition() {
        homePage.openPage();
    }

    @Test(priority = 1)
    public void contextMenu_Test() {
        homePage.clickOnExample(CONTEXT_MENU);
        contextMenuPage
                .verifyPageTitle()
                .clickBoxBelow()
                .checkAlertText();
    }

    @Test(priority = 2)
    public void dynamicControls_Test() {
        homePage.clickOnExample(DYNAMIC_CONTROLS);
        dynamicControlsPage.verifyPageTitle().verifyClickOnCheckbox();
    }

    @Test(priority = 3)
    public void fileUploader_Test() {
        homePage.clickOnExample(FILE_UPLOAD);
    }


}
