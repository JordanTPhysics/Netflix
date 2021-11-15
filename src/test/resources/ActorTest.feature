Feature: Actors in the database

  Scenario: An actor is added to the database
    Given a new actor
    When the actor is put in
    Then the actor will be found