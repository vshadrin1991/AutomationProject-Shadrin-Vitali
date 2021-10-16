package Lecture_22.steps;

import PageObject.Moodpanda.HomePage;
import driver.BaseTestSelenide;
import io.cucumber.java.After;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeSteps extends BaseTestSelenide {

    @When("open page")
    public void openPage() {
        get(HomePage.class);
    }

    @Then("check home page")
    public void checkHomePage() {
        get(HomePage.class)
                .checkBrandNameSubtext()
                .checkImage();
    }

    @After
    public void postconditions(){
        close();
    }
}
