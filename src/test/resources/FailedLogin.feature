Feature: Failed login functionality

  Scenario: Unsuccessful login with invalid credentials
    Given I launch the app
    When I enter the username "yoana"
    And I enter the password "12345678"
    And I click the login button
    Then I should see an error message "Username and password do not match any user in this service."
