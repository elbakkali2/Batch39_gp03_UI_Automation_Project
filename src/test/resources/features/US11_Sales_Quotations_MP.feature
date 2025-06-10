Feature: Manage quotations on the Sales page by different user roles

  @maryna
  Scenario Outline: User manages quotations
    Given "<role>" user is logged in to the system
    And user navigates to the Sales page
    When user clicks the Quotation Number checkbox
    Then all quotations in the list should be selected
    Examples:
      | role          |
      | POS           |
      | Sales Manager |


