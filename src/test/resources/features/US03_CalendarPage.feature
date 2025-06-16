@Esmira
Feature: Calendar Display Options

  User Story:
  As a user, I want to see the calendar page as daily,weekly (as a default) and monthly.


  Scenario: Verify users see the calendar as a daily
    Given user is on the login page
    When user navigates to the calendar page
    Then user selects the daily view option
    Then user should see the calendar displayed in daily format

  Scenario: Verify users see the calendar as a weekly
    Given user is on the login page
    When user navigates to the calendar page
    Then user selects the weekly view option
    Then user should see the calendar displayed in weekly format

  Scenario: Verify users see the calendar as a monthly
    Given user is on the login page
    When user navigates to the calendar page
    Then user selects the monthly view option
    Then user should see the calendar displayed in monthly format
