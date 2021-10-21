package Lecture_22.steps;

import PageObject.Moodpanda.HomePage;
import driver.BaseTestSelenide;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePage_Steps extends BaseTestSelenide {

    @When("load page {string}")
    public void loadPage(String url){
        get(HomePage.class, url);
    }

    @When("page open")
    public void openPage(){
        get(HomePage.class);
    }

    @Then("check mood panda home page is open")
    public void checkHomePage(){
        get(HomePage.class)
                .checkBrandNameSubtext()
                .checkImage();
    }

}
