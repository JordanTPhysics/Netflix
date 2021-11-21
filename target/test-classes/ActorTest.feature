Feature: Actors in the database

  Scenario: An actor is added to the database
    Given user adds a new Actor
    When the user searches for Actor ID 200
    Then the Actor with ID 200 will be found

  Scenario: A user is looking for a list of actors
    Given user wants to list all actors
    When the actors are requested
    Then all actors are returned