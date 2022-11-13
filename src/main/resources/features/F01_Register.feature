@smoke
Feature: F01_Register | users could register with new accounts
  Scenario: Scenario: guest user could register with valid data successfully
    Given user go to register page
  Then user select gender type
  Then user enter first name automation
   Then user enter last name tester
  When  user enter day of birth
    When  user enter Month of birth
      When  user enter Year of birth
#  Then  user enter email "test@example.com" field
#    Then 6 user fills Password fields "P@ssw0rd" "P@ssw0rd"
#    Then 7 user clicks on register button
#  Then 8 success message is displayed

