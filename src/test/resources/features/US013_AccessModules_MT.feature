Feature: Access main modules as POS Manager
  As a POS Manager
  I want to verify I can see and access all main top menu modules
  So that I can perform my duties efficiently

  @MT
  Scenario: Verify visibility of main modules on the top menu
    Given the user is logged in as a POS Manager
    When the user navigates to the homepage
    Then the user should see the following modules:
      | Discuss       |
      | Calendar      |
      | Notes         |
      | Contact       |
      | CRM           |
      | Sales         |
      | Website       |
      | Point of Sale |
      | Purchases     |
      | Inventory     |
      | Manufacturing |
      | Repairs       |
      | Projects      |
      | Events        |
      | Surveys       |
      | Employees     |
      | Attendances   |
      | Leaves        |
      | Expenses      |
      | Maintenance   |
      | Fleet         |
      | Dashboards    |

  Scenario: Verify the POS Manager can access each module
    When the user clicks on each module from the top menu
    Then the corresponding page for each module should be displayed