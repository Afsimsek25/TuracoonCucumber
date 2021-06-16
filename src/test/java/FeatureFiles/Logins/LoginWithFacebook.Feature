Feature: Login Functionality
  Scenario: Login with Register
    Given Navigate to turacoon
    When Go to login page
    When Select Facebook option and switch window
    When Enter email and password and click login button
    Then User should login successfully