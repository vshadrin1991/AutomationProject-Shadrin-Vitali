package Lecture_18;

import SelenidePages.HomePage;
import driver.SelenideBaseTest;
import org.testng.annotations.Test;

public class MoodPanda_Tests extends SelenideBaseTest {

    @Test
    public void checkHomePage_Test() {
        get(HomePage.class).verifyHomePage().clickScrollDown();
    }
}
