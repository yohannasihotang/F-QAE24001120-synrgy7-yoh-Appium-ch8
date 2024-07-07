Feature: Sorting functionality

  Scenario: Successful login and sort products by price from low to high
    Given I launch the app
    When I enter the username "standard_user"
    And I enter the password "secret_sauce"
    And I click the login button
    Then I should see the products page
    When I click the filter button
    And I select sort by price low to high
    Then I should see the first item price is displayed
