Feature: Movie attributes

  Scenario: Checking the movie title
    Given a movie from database
    When I check the title
    Then I should be told title is correct