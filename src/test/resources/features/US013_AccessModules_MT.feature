@MT
Feature: Access main modules as POS Manager
  As a POS Manager
  I want to verify I can see and access all main top menu modules
  So that I can perform my duties efficiently


  Scenario: Verify visibility of main modules on the top menu
    Given the manager is logged in as a POS Manager
    When the manager navigates to the homepage
    Then the manager should see the following modules:
      | Discuss       |
      | Calendar      |
      | Notes         |
      | Contacts      |
      | CRM           |
      | Sales         |
      | Website       |
      | Point of Sale |
      | Purchases     |
      | Inventory     |
      | Manufacturing |
      | Repairs       |
      | Project       |
      | Events        |
      | Surveys       |
      | Employees     |
      | Attendances   |
      | Leaves        |
      | Expenses      |
      | Maintenance   |
      | Fleet         |
      | Dashboards    |

    When the manager clicks on each module from the top menu