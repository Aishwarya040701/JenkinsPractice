@Login
Feature: To check login functionality of sauce website

  Background: 
    Given User is on login page

  @ValidLoginTest
  Scenario: To verify login with valid username and password
    Given User enter valid username as "standard_user"  and password as "secret_sauce"
    When click on login button
    Then User should be able to login and navigate to products page

  @InvalidLoginTest
  Scenario Outline: To verify login with invalid username and password
    Given User enter invalid username "<username>"  and password as "<password>"
    When click on login button
    Then User should not be able to login and error message "<errorMessage>" is displayed

    Examples: 
      | username        | password     | errorMessage                                                              |
      | Arya            | Arya@123     | Epic sadface: Username and password do not match any user in this service |
      | standard_user   | Arya@123     | Epic sadface: Username and password do not match any user in this service |
      |                 |              | Epic sadface: Username is required                                        |
      | standard_user   |              | Epic sadface: Password is required                                        |
      | locked_out_user | secret_sauce | Epic sadface: Sorry, this user has been locked out.                       |
