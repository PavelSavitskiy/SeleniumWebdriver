Feature: Log in basic test

  Scenario: user can log in with valid credentials
    When  user click to Sign In button
    And   enters user credentials and submits login form
    Then  user's personal data is on the current page
  