Feature: Access Odoo Documentation Page
  As a user,
  I want to open the documentation page
  So that I can view helpful documentation topics.

  Background:
    Given user logged on as CRM_Manager with "eventscrmmanager1@info.com" and "eventscrmmanager"
    And I am logged on

  Scenario: Open documentation and verify topics
    Given I am logged into the application
    When I click on the "Documentation" link
    Then a new window should open with the title "Odoo Documentation"
    And I should see 4 main documentation topics:
      | User Doc            |
      | Install and Maintain|
      | Developer           |
      | Contribute          |
