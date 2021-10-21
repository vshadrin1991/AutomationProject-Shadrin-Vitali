Feature: Test
  Scenario: Check home page
    When load page "https://moodpanda.com/"
    Then check mood panda home page is open
  Scenario: Check testimonials page
    When click scroll down button
    Then verify testimonials page texts "FOR MOOD-TRACKING"
    Then verify testimonials page texts "MOBILE & WEB APP"