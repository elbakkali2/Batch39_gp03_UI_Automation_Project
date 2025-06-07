@login @POS @orders @After

Feature: POS manager views product orders

  Background:
    Given the POS manager logs into the system with valid credentials

  Scenario: Verify POS manager can see product orders with Order Reference
    When the POS manager navigates to the "Point of Sale" page
    Then  the POS manager clicks the "Orders" menu under Dashboard
    And all the orders list should be displayed
    And each order should have a non-empty Order Reference
    When  the POS manager checks the "Order Ref" checkbox
    Then all the orders list should be checked


   Scenario: Verify Action dropdown has Import,Export, and Delete options
     When the POS manager navigates to the "Point of Sale" page
     And the POS manager clicks to the "Orders" menu under Dashboard
     Then the POS manager checks the "Order Ref" checkbox
     And the POS manager clicks the "Action" dropdown
     Then the dropdown should contain the following options:
       | Import |
       | Export |
       | Delete |