Feature: Movie attributes

  Scenario: Update description of movies
    Given a movie with a description and ID 25
    When I change the description of movie 25
    Then the movie will be updated


  Scenario: Deleting inaccessible movie
    Given an unused movie with ID 758 in database
    When the user deletes the movie with ID 758
    Then the movie ID 758 will not be found