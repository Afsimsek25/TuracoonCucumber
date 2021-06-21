Feature: Pricing Page Tests

  Background:
    Given Navigate to turacoon
    When Go to Pricing Page


  Scenario: Customization of products
    When User wants to customize the Products
    Then Products should be Customizable

  Scenario: Purchase with non-login user
    When User selects a product
    When Enter username and password and click login button
    Then After that user should be redirected to the payment page

  Scenario: Iyzico Payments
    When User selects a product
    When Enter username and password and click login button
    When User enters the Iyzico Card information and clicks the Buy Button
    Then Verify Iyzico Purchase Success Message

  Scenario: Stripe Payments
    When User selects a product
    When Enter username and password and click login button
    When User enters the Stripe Card information and clicks the Buy Button
    Then Verify Stripe Purchase Success Message

  Scenario: Trial Pack Purchase
    When User Select to Trial Pack
    When Fill Register Form and click Register button
    When User enters the Iyzico Card information and clicks the Buy Button
    Then Verify Iyzico Purchase Success Message
    Then Delete the User






  Scenario: Trial Pack With Course Planned User
    When User selects a product
















