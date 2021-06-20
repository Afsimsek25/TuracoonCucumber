Feature: Pricing Page Tests

  Background:
    Given Navigate to turacoon
    When Go to Pricing Page


  Scenario: Customization of products
    When User wants to customize the Products
    Then Products should be Customizable

  Scenario: Purchase with non-login user
    When Not logged User wants to make a purchase
    And Must login or register first
    Then After that user should be redirected to the payment page

  Scenario: Iyzico Payments
    When User selects a product
    Then Must login first
    And After that user should be redirected to the payment page
    And User enters the Iyzico Card information and clicks the Buy Button
    Then Verify Iyzico Purchase Success Message

  Scenario: Stripe Payments
    When User selects a product
    Then Must login first
    And After that user should be redirected to the payment page
    And User enters the Stripe Card information and clicks the Buy Button
    Then Verify Stripe Purchase Success Message















