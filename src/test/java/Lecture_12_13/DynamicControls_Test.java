package Lecture_12_13;

import PageObject.Herokuapp.DynamicControlsObject;
import PageObject.Herokuapp.HomePageObject;
import driver.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static PageObject.Herokuapp.HomePageLinksEnum.DYNAMIC_CONTROLS;

public class DynamicControls_Test extends BaseTest {
    DynamicControlsObject dynamicControlsObject;
    HomePageObject homePageObject;

    @BeforeClass
    public void precondition() {
        dynamicControlsObject = new DynamicControlsObject(driver);
        homePageObject = new HomePageObject(driver);
        homePageObject.clickLink(DYNAMIC_CONTROLS);
    }

    @Test
    public void dynamicControlsObject_Test() {
        dynamicControlsObject.verifyPageTitle().clickRemoveBtn().verifyElementText("It's gone!");
    }

}
