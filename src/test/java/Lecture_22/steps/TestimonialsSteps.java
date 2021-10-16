package Lecture_22.steps;

import PageObject.Moodpanda.HomePage;
import PageObject.Moodpanda.TestimonialsPage;
import driver.BaseTestSelenide;
import io.cucumber.java.After;
import io.cucumber.java.en.Then;

public class TestimonialsSteps extends BaseTestSelenide {

    @Then("click scroll down")
    public void clickScrollDownBtn() {
        get(HomePage.class)
                .clickScrollDownBtn();
    }

    @Then("verify testimonials page")
    public void verifyTestimonialsPage() {
        get(TestimonialsPage.class)
                .verifyContentText("FOR MOOD-TRACKING")
                .verifyContentText("MOBILE & WEB APP");
    }

}
