Feature: Checkout functionality

  Scenario: Successful login and checkout process
    Given I launch the app
    When I enter the username "standard_user"
    And I enter the password "secret_sauce"
    And I click the login button
    Then I should see the products page
    When I add two items to the cart
    And I go to the cart page
    And I click the checkout button
    And I fill in checkout information with first name "Yohanna", last name "Sihotang", and postal code "11421007"
    And I click the finish button
    Then I should see the checkout complete message "CHECKOUT: COMPLETE!"
