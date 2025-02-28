Feature: Login Functionality for SauceDemo Website

  As a user of the SauceDemo website
  I want to be able to log in with my account
  So that I can access my account and perform actions

  Background:
    Given I am on the sauceDemo login page

  Scenario: Successful login with valid credentials
    Given I have entered valid login credentials
    When I click on the login button
    Then I should be redirected to the home page
    When I click on the hamburger menu
    Then the Logout button should be displayed successfully

  Scenario Outline: Unsuccessful login with invalid credentials
    Given I have entered the username "<username>" and password "<password>"
    When I click on the login button
    Then I should see an error message "<error_message>"

    Examples:
      | username      | password     | error_message                                                             |
      | wrongUser     | secret_sauce | Epic sadface: Username and password do not match any user in this service |
      | standard_user | wrongPass    | Epic sadface: Username and password do not match any user in this service |
      |               | secret_sauce | Epic sadface: Username is required                                        |
      | standard_user |              | Epic sadface: Password is required                                        |
