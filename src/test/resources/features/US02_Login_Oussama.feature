Feature: US02. As a sales and expense manager, I want to login with valid credentials and get my account name.

  @oussama
  Scenario Outline: User logs in with valid credentials
    Given the user is on the login page
    When the user enters valid "<username>" and "<password>"
    Then the user's account name should be displayed

    Examples:
      | username                | password     |
      | salesmanager15@info.com| salesmanager |
      | salesmanager10@info.com| salesmanager |
      | salesmanager43@info.com| salesmanager |

  @oussama
  Scenario Outline: User logs in with invalid credentials
    Given the user is on the login page
    When the user enters invalid "<username>" or "<password>"
    Then the error message "Wrong login/password" should be displayed

    Examples:
      | username               | password     |
      | salesmanager@gmail.com| salesmanager |
      | salesmanager10@info.com| sale        |

  @oussama
  Scenario Outline: User submits blank credentials
    Given the user is on the login page
    When the user leaves either the "<username>" or "<password>" field blank
    Then the browser should display the message "Please fill out this field."

    Examples:
      | username | password  |
      |          | salesmanager |
      | salesmanager15@info.com |        |
