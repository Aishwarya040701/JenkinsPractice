@Product
Feature: To check product page functionality

  Background: 
    Given User is on sauce demo website
    And user login with valid username as "standard_user" and password as "secret_sauce" to sauce website

  @VerifyCartValue
  Scenario Outline: To verify cart value
    Given User as navigated to products page
    When user add products to cart "<method>"
    Then check cart value with expected result cartValue "<cartvalue>"

    Examples: 
      | method                | cartvalue |
      | addToCartTwoProducts  |         2 |
      | addToCartFourProducts |         4 |
      | removeFromCart        |         2 |

  @VerifyFilterOption
  Scenario Outline: To verify filter in products page
    Given User as navigated to products page
    When user click on filter options with value "<filtervalue>"
    Then the products should be sorted based on the value and the first product is "<product>" and "<results>"

    Examples: 
      | filtervalue | product                           | results                   |
      | za          | Test.allTheThings() T-Shirt (Red) | z to a sorting            |
      | lohi        | Sauce Labs Onesie                 | low to high price sorting |
      | hilo        | Sauce Labs Fleece Jacket          | high to low price sorting |
      | az          | Sauce Labs Backpack               | a to z sorting            |
