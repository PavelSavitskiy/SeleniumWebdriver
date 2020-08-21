Feature: Change user's password

  Scenario: user can change password and log in after that with new one
    Given user opens browser
    And the link is opened in browser
    And user is signed in
    When  user goes to user section
    And goes to change password sub section
    And user changes password
    And user signs out
    Then  he can sign in with new one
    And user's personal data is on the current page
    Then password is changed to old one