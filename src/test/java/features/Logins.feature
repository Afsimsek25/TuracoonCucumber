Feature: Login Functionality


  Background:
    Given Navigate to turacoon
    When Go to login page


  @Regression
  Scenario: Login with email
    When Enter username and password and click login button
    Then User should login successfully


  @Regression
  Scenario: Login with facebook
    When Select Facebook option and switch window
    And Enter email and password and click login button
    Then User should login successfully





