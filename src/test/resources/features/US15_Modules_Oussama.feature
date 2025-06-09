@el
Feature: US15. As an Event manager, I want to access the different modules.

  Scenario: Accessing Event Management System Modules

    Given the user is logged in as an Event Manager
    When the Event Manager navigates to the main dashboard
    Then the system should display access to the following 15 modules:
      | Discuss         |
      | Calendar        |
      | Notes           |
      | Contacts        |
      | CRM             |
      | Sales           |
      | Website         |
      | Inventory       |
      | Repairs         |
      | Events          |
      | Employees       |
      | Leaves          |
      | Expenses        |
      | Maintenance     |
      | Dashboards      |

