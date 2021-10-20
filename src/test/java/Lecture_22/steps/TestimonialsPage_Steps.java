package Lecture_22.steps;

import PageObject.Moodpanda.HomePage;
import PageObject.Moodpanda.TestimonialsPage;
import driver.BaseTestSelenide;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestimonialsPage_Steps extends BaseTestSelenide {

    @When("click scroll down button")
    public void clickScrollDownButton() {
        get(HomePage.class)
                .clickScrollDownBtn();
    }

    @Then("verify testimonials page texts {string}")
    public void verifyTestimonialsPage(String text) {
        get(TestimonialsPage.class)
                .verifyContentText(text);
    }
}
