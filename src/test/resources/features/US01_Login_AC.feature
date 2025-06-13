@anthony
Feature: Login functionality

  As a POS and event-CRM manager
  I should be able to login with valid credentials


  Scenario Outline: Successful login with valid POS credentials using Login button
   # Given User is on the login page
    When User enters valid POS credentials "<username>" and "<password>"
    And User clicks the login button
    Then User should be logged in successfully

    Examples:
      | username                    |password|
      | posmanager5@info.com        |posmanager|
      | posmanager45@info.com       |posmanager|
      | posmanager65@info.com       |posmanager|
      | posmanager85@info.com       |posmanager|
      | eventscrmmanager66@info.com  |eventscrmmanager|
      | eventscrmmanager16@info.com |eventscrmmanager|
      | eventscrmmanager36@info.com |eventscrmmanager|
      | eventscrmmanager76@info.com |eventscrmmanager|



  Scenario Outline: Successful login with valid Event-CRM credentials using Enter key
    #Given User is on the login page
    When User enters valid POS credentials "<username>" and "<password>"
    And User presses the Enter key
    Then User should be logged in successfully
    Examples:
      | username                    | password         |
      | posmanager10@info.com       | posmanager       |
      | posmanager20@info.com       | posmanager       |
      | posmanager30@info.com       | posmanager       |
      | posmanager40@info.com       | posmanager       |
      | posmanager50@info.com       | posmanager       |
      | posmanager60@info.com       | posmanager       |
      | posmanager70@info.com       | posmanager       |
      | eventscrmmanager10@info.com | eventscrmmanager |
      | eventscrmmanager20@info.com | eventscrmmanager |
      | eventscrmmanager30@info.com | eventscrmmanager |
      | eventscrmmanager40@info.com | eventscrmmanager |
      | eventscrmmanager50@info.com | eventscrmmanager |
      | eventscrmmanager60@info.com | eventscrmmanager |
      | eventscrmmanager70@info.com | eventscrmmanager |


  Scenario: Display error message on invalid credentials
    When User enters invalid username or password
    Then Wrong login or password error message should be displayed


  Scenario: Display error message for blank fields
    When User leaves at least one field blank
    Then Please fill out this field validation message is displayed








