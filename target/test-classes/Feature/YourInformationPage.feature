@Information
Feature: To check your information page functionality of sauce website

  Background: 
    Given User is on sauce demo website login page
    And User will complete product checkout process till your information page

  @ValidInformationTest
  Scenario: To verify registration with valid information
    Given User is on your information page
    When user enter valid firstName as "Arya" lastName as "Raj" and postalCode as "573201"
    Then User should be able navigate to overview page

  @InvalidInformationTest
  Scenario Outline: To verify registration with blank information
    Given User is on your information page
    When user enter valid firstName "<firstName>" lastName "<lastName>" and postalCode "<postalCode>"
    Then User should get correct error meassage "<errorMeassge>"

    Examples: 
      | firstName | lastName | postalCode | errorMeassge                   |
      |           |          |            | Error: First Name is required  |
      | Arya      |          |            | Error: Last Name is required   |
      | Arya      | Raj      |            | Error: Postal Code is required |
      | Ziva      |          |      34567 | Error: Last Name is required   |
      |           | Ram      |      34534 | Error: First Name is required  |
