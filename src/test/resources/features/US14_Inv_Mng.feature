Feature:As an Inventory manager, I should be able to access the main modules.
    As an Inventory Manager
    I want to verify I can see and access all main top menu modules
    So that I can perform my duties efficiently
@INV_MNG
    Scenario: Verify Inventory Manager can access the main modules when logged in
        Given the user is logged in as an "Inventory Manager"
        When the user navigates to the main modules area
        Then all the following modules should be accessible
        | Module Name   |
        | Discuss       |
        | Calendar      |
        | Notes         |
        | Contacts      |
        | Website       |
        | Inventory     |
        | Manufacturing |
        | Repairs       |
        | Invoicing     |
        | Timesheets    |
        | Employees     |
        | Leaves        |
        | Expenses      |
        | Lunch         |
        | Maintenance   |
        | Dashboards    |

    Scenario: Verify the Inventory Manager can access each module
        When the user clicks on each module from the top menu
        Then the corresponding page for each module should be displayed
        And the user should be able to perform actions within each module
        And the user should see relevant data and functionalities in each module
