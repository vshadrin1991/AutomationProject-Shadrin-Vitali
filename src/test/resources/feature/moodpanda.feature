Feature: Mood panda tests

 Scenario: Check home page
   When open page
   Then check home page

  Scenario: Check testimonials page
    When open page
    Then click scroll down
    Then verify testimonials page

  Scenario: Check about
    When navigate to about page
    Then check about page