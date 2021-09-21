package Lecture_12_13;

import PageObject.Herokuapp.FramesObject;
import PageObject.Herokuapp.HomePageLinksEnum;
import PageObject.Herokuapp.HomePageObject;
import driver.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Frames_Test extends BaseTest {
    FramesObject framesObject;

    @BeforeClass
    public void precondition() {
        framesObject = new FramesObject();
    }

    @Test
    public void frames_Test() {
        HomePageObject homePageObject =  new HomePageObject();
        homePageObject.clickLink(HomePageLinksEnum.FRAMES);
        framesObject
                .verifyPageTitle("Frames")
                .clickFrameLink("iFrame")
                .verifyPageTitle("An iFrame containing the TinyMCE WYSIWYG Editor")
                .verifyFrameText("Your content goes here.");
    }

}


