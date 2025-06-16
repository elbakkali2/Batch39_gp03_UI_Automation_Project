Feature: Sales Manager creates new customer from Sales module.

  @melisa
  Scenario Outline: As a Sales Manager, I should be able to create a new customer from "Sales" module
    Given user enters correct "<email>" and "<password>"
    And The user can create a new customer by filling only the Name input box and after clicking the save button.
    And The information of the customer which the user entered should be displayed.
    Then All the boxes entered information can be editable again after clicking any customer and then clicking the edit button.
    Examples:
      | email                   | password     |
      | salesmanager15@info.com | salesmanager |
      | salesmanager50@info.com | salesmanager |
      | salesmanager88@info.com | salesmanager |


