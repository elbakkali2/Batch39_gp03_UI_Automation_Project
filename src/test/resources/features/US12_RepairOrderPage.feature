
Feature:Manage Repair Orders on the Repairs Page

@here
Scenario: Successful login and role display
  When user logged on as POS & Sales Manager
  Then user can successfully log in the page and sees the user role on the top right

  Scenario: Select all repair orders using the top checkbox
    When the user clicks the top checkbox to select all repair orders
    Then all repair orders should be selected

  Scenario: Verify Print and Action dropdowns are visible
    Then the "Print" dropdown should be visible
    And the "Action" dropdown should be visible

  Scenario: Verify Action dropdown contains Export, Delete, Create Invoice
    When the user clicks the "Action" dropdown
    Then the Action dropdown should contain the following options:
      | Export        |
      | Delete       |
      | Create Invoice |
