package Lecture_12_13;

import PageObject.Herokuapp.DynamicControlsObject;
import PageObject.Herokuapp.HomePageLinksEnum;
import PageObject.Herokuapp.HomePageObject;
import driver.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static PageObject.Herokuapp.HomePageLinksEnum.DYNAMIC_CONTROLS;

public class DynamicControls_Test extends BaseTest {
    DynamicControlsObject dynamicControlsObject;

    @BeforeClass
    public void precondition() {
        dynamicControlsObject = new DynamicControlsObject(driver);
    }

    @Test
    public void dynamicControlsObject_Test() {
        HomePageObject homePageObject =  new HomePageObject(driver);
        homePageObject.clickLink(DYNAMIC_CONTROLS);
        dynamicControlsObject.verifyPageTitle().clickRemoveBtn().verifyElementText("It's gone!");
    }

}
