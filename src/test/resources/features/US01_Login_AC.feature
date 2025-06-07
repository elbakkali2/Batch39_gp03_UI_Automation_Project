@login

Feature: Login functionality

  As a POS and eventCRM manager
  I want to login with valid credentials
  So that I can access the system

  Scenario: Successful login with valid credentials using Login button
    Given the user is on the login page
    When the user enters valid username and password
    And clicks the login button
    Then the user should be logged in successfully

  Scenario: Successful login with valid credentials using Enter key
    Given the user is on the login page
    When the user enters valid username and password
    And presses the Enter key
    Then the user should be logged in successfully


  Scenario: Display error message on invalid credentials
    Given the user is on the login page
    When the user enters invalid username or password
    And clicks the login button
    Then the "Wrong login/password" error message should be displayed

  Scenario: Display error message for blank fields
    Given the user is on the login page
    When the user leaves at least one field blank
    And clicks the login button
    Then the "Please fill out this field." validation message should be displayed

  @wip
  Scenario: Verify login with different user types
    Given the user logged in as "<userType>"
    Given the user logged in with username as "User1" and password as "UserUser123"

# you can use one of the given step here
