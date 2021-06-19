Feature: Home Page Tests
  Background:
    Given Navigate to turacoon

#    Scenario: Create Free Account Button Functions
#      When Click Create Free Account Buttons
#      Then User should be redirected registration page

    Scenario: Language Selector Options
      When User changes language
      Then Page language should change

