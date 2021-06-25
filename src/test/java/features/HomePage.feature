Feature: Home Page Tests

  Background:
    Given Navigate to turacoon

  @Regression
  Scenario: Create Free Account Button Functions
    When Click Create Free Account Buttons
    Then User should be redirected registration page

  @Regression
  Scenario: Language Selector Options
    When User clicks on the Turkish option
    Then Page language should be Turkish

    When User clicks on the English option
    Then Page language should be English

    When User clicks on the Arabic option
    Then Page language should be Arabic

    When User clicks on the Persian option
    Then Page language should be Persian

  @Regression
  Scenario: Navigation Links
    When User clicks on the Pricing Page
    Then User should be redirected Pricing Page

    When User clicks on the HowItWorks Page
    Then User should be redirected HowItWorks Page

    When User clicks on the FAQ Page
    Then User should be redirected FAQ Page

    When User clicks on the SampleLesson Page
    Then User should be redirected SampleLesson Page

    When User clicks on the Tutors Page
    Then User should be redirected Tutors Page

    When User clicks on the Blog Page
    Then User should be redirected Blog Page

    When User clicks on the Companies Page
    Then User should be redirected Companies Page




