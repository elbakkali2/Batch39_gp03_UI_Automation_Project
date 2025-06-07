@login @POS @orders

Feature: POS manager views product orders

  Background:
    Given user is on the login page
    And the user logged in as "POS Manager"

  Scenario: Verify POS manager can see product orders with Order Reference
    When the POS manager navigates to the "Orders" page under the "Point of Sale"
    Then the order list should be displayed
    And each order should have a non-empty Order Reference

  Scenario: Verify Action dropdown has Import,Export, and Delete options
    When the POS manager navigates to the "Orders" page under "Point of Sale"
    And the POS manager opens the Action dropdown
    Then the dropdown should contain the following options:
      | Import |
      | Export |
      | Delete |