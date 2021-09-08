package Lecture_12;

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
        homePageObject.open().verifyHomePage();
    }
}
