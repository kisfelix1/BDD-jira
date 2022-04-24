Feature: Log in Jira's main page
  We want to log in Jira and access its features

  Scenario: Try proper login credentials
    Given Jira page is open
    When user enters proper passwords
    And clicks login button
    Then I see the create button
    And I see a user logged in