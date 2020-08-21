Feature: Add goods to cart test

  Scenario: user can add goods to his cart
    Given user opens browser
    And the link is opened in browser
    And user is signed in
    And quantity of goods on cart is counted
    When  user adds goods on cart "Паста"
    Then  quantity of goods on cart goes up by one
    Then user delete this  goods from cart

