
  Feature: US02. As sales and expense manager, I want to Login with valid credentials and get my account name.
    @oussama
    Scenario Outline: User attempts to log in with valid, invalid, and blank credentials
      Given the user is on the login page

  # Valid credentials
      When the user enters valid "<username>" and "<password>"
      And submits the form by clicking Login or pressing Enter
      And the user's account name should be displayed

      Examples:


     |         username      |password    |
     |salesmanager15@info.com|salesmanager|
     |salesmanager10@info.com|salesmanager|
     |salesmanager43@info.com|salesmanager|
    @oussama
    Scenario Outline: User attempts to log in with valid, invalid, and blank credentials
  # Invalid credentials
      When the user logs out and returns to the login page
      And the user enters invalid "<username>" or "<password>"
      Then the error message "Wrong login/password" should be displayed

     Examples:


       |         username      |password    |
       |salesmanager@gmail.com |salesmanager|
       |salesmanager10@info.com|   sale     |

    @oussama
    Scenario Outline: User attempts to log in with valid, invalid, and blank credentials
  # Blank fields
      When the user leaves either the "<username>" or "<password>" field blank
      Then the browser should display the message "Please fill out this field."

     Examples:


       |         username      |password    |
       |            empty      |            |
       |                       |    empty   |

