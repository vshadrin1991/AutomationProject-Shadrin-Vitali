package Lecture_22.steps;

import PageObject.Moodpanda.HomePage;
import PageObject.Moodpanda.TestimonialsPage;
import driver.BaseTestSelenide;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeSteps extends BaseTestSelenide {

    @When("open page")
    public void openPage() {
        get(HomePage.class)
                .checkBrandNameSubtext()
                .checkImage();
    }


    @Then("verify testimonials page")
    public void verifyTestimonialsPage() {
        get(HomePage.class)
                .clickScrollDownBtn();

        get(TestimonialsPage.class)
                .verifyContentText("FOR MOOD-TRACKING")
                .verifyContentText("MOBILE & WEB APP");
    }
}
