Feature: View and search repair orders

  As a POS & Sales Manager,
  I want to access the Repairs page
  So I can view and search repair orders.


 # Background:


 # Scenario Outline:
  #  Given  user logged on as POS & Sales Manager with "<username>" and "<password>"
   # And I am on the Repairs page

   # Examples:
    #  | username                 | password     |
     # | salesmanager6@info.com   | salesmanager |
     # | salesmanager105@info.com | salesmanager |
     # | posmanager5@info.com     | posmanager   |


 # Scenario Outline: View repair orders with all required columns
  #  Given  user logged on as POS & Sales Manager with "<username>" and "<password>"
   # And I am on the Repairs page
   # Then I should see 6 columns in the repair orders table:
    #  | Repair Reference    |
     # | Product to Repair   |
     # | Customer            |
      #| Delivery Address    |
      #| Warranty Expiration |
     # | Status              |


   # Examples:
     #| username                 | password     |
     #| salesmanager6@info.com   | salesmanager |
     #| salesmanager105@info.com | salesmanager |
     #| posmanager5@info.com     | posmanager   |
  @aisha
  Scenario Outline: Verify repair orders table columns and search by Repair Reference
    Given user logged on as POS & Sales Manager with "<username>" and "<password>"
    And I am on the Repairs page
    Then I should see 6 columns in the repair orders table:
      | Repair Reference    |
      | Product to Repair   |
      | Customer            |
      | Delivery Address    |
      | Warranty Expiration |
      | Status              |
    When I enter a "<reference>" into the search field
    And I click the search button
    Then the matching repair order should appear in the results

    Examples:
      | username                 | password     | reference |
      | salesmanager6@info.com   | salesmanager | RMA/00246 |
      | salesmanager105@info.com | salesmanager | RMA/00245 |
      | posmanager5@info.com     | posmanager   | RMA/00243 |
