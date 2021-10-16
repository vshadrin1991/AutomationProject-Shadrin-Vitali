package Lecture_22.steps;

import PageObject.Moodpanda.AboutPage;
import PageObject.Moodpanda.HomePage;
import PageObject.Moodpanda.Titles;
import driver.BaseTestSelenide;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AboutSteps extends BaseTestSelenide {

    @When("navigate to about page")
    public void navigateToAboutPage(){
        get(HomePage.class).clickTitle(Titles.ABOUT);
    }

    @Then("check about page")
    public void checkAboutPage(){
        get(AboutPage.class).verifyAboutPage("ABOUT US");
    }
}
