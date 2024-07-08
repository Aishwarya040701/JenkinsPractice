@ProductCheckout
Feature: product checkout

  Background: 
    Given User is on sauce website
    And user login with valid username as "standard_user" password as "secret_sauce" to sauce website

  @ProductCheckoutTest
  Scenario: To add products to cart and complete the checkout process
    Given User is on products page
    When user add products to cart
    And move to cart page
    And click on checkout button
    And enter the details
    And click on continue button
    And click on finish
    Then product checkout should be completed and message to be displayed
    And logout from website
