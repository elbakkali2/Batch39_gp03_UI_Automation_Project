Feature: US16 As an Expenses Manager, I should be able to access the different modules



  Scenario: Expenses Manager logs in and accesses all available modules
    When the user enters valid credentials for the Expenses Manager
    And the user should see their username in the top right corner
    And the user should see the following modules:
      | Discuss     |
      | Calendar    |
      | Notes       |
      | Contacts    |
      | Website     |
      | Events      |
      | Employees   |
      | Leaves      |
      | Expenses    |
      | Lunch       |
      | Maintenance |
      | Dashboards  |
