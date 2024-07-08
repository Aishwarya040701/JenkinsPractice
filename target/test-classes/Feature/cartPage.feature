@Cart
Feature: To verify products in cart page

  Background: 
    Given User is on sauce website login page
    And user login with valid username as "standard_user" and valid password as "secret_sauce" to sauce website

  @CheckProductDisplayed
  Scenario: To verify products added are displayed on cart page
    Given User add products to cart
    When user move to cart page
    Then verify products that are added are displayed in cartpage

  @VerifyProducts
  Scenario: To verify products added and products in cart page are same
    Given User add products to cart
    When user move to cart page
    Then verify products that products added and products in cart are same
