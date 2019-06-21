Feature: Test Login Functionality

  Scenario: Login with Valid Credentials
    Given user is on home page
    When user enters username and password
    Then user logged in successfully
