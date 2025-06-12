
@maryna
Feature: Manage quotations on the Sales page by different user roles


  Scenario Outline: User manages quotations
    Given "<role>" user is logged in to the system
    And user navigates to the Sales page
    When user clicks the Quotation Number checkbox
    Then all quotations in the list should be selected
    Examples:
      | role          |
      | POS           |
      | Sales Manager |


    Scenario Outline: Verify Print Dropdown shows correct options after selecting quotations
      Given "<role>" user is logged in to the system
      And user navigates to the Sales page
      When user clicks the Quotation Number checkbox
      Then the Print dropdown should be visible
      And the option Quotation / Order  should appear under the Print dropdown
      Examples:
        | role |
        | POS           |
        | Sales Manager |


