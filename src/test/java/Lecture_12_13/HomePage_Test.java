package Lecture_12_13;

import PageObject.Herokuapp.HomePageObject;
import driver.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePage_Test extends BaseTest {
    HomePageObject homePageObject;

    @BeforeClass
    public void precondition() {
        homePageObject = new HomePageObject(driver);
    }


    @Test
    public void verifyHomePageObject_Test() {
        homePageObject.openPage().verifyHomePage();
    }
}
