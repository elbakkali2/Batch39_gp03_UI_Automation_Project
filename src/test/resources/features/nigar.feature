Feature: Access Documentation Page

  @nigar @documentation @regression
  Scenario Outline: Open documentation and verify topics
    Given the user is logged on with "<username>" and "<password>"
    When the user clicks the Documentation link
    Then a new window opens with the header "Odoo Documentation"
    And the page shows the following topics:
      | User Doc             |
      | Install and Maintain |
      | Developer            |
      | Contributing           |

    Examples:
      | username               | password|
      | imm10@info.com         | inventorymanager|
      | salesmanager6@info.com | salesmanager    |


