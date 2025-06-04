@login

Feature: US01. As POS and eventCRM manager, I should be able to Login with valid credentials.

  Background: User is already in the log in page
    Given the user is on the login page

  @wip
  Scenario: Verify login with different user types
    Given the user logged in as "<userType>"
    Given the user logged in with username as "User1" and password as "UserUser123"

# you can use one of the given step here
