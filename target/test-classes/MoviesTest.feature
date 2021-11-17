Feature: Movie attributes

  Scenario: Checking the movie information
    Given the film with title {string} is in the database
    When I search for film with title {string}
    Then I should see film info