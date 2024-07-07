Feature: Login functionality

  Scenario: Successful login with valid credentials
    Given I launch the app
    When I enter the username "standard_user"
    And I enter the password "secret_sauce"
    And I click the login button
    Then I should see the products page
