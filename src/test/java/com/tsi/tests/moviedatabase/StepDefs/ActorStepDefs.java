package com.tsi.tests.moviedatabase.StepDefs;

import com.TSI.MovieDatabase.Actor;
import com.TSI.MovieDatabase.ActorRepository;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.Optional;

public class ActorStepDefs {

    Actor testActor;
    int actorId;
    String firstName;
    String lastName;

    @Autowired
    ActorRepository actorRepository;

    @Given("a new actor")
    public void aNewActor() {
        actorId = 203;
        firstName = "Jason";
        lastName = "Mason";

    }
    @When("the actor is put in")
    public void theActorIsPutIn() {
    testActor = new Actor(actorId,firstName,lastName);
    actorRepository.save(testActor);

    }
    @Then("the actor will be found")
    public void theActorWillBeFound() {
        int expectedId = testActor.getActorId();
        Optional<Actor> actualActorOption = actorRepository.findById(expectedId);
        Actor actualActor = actualActorOption.get();
        assertTrue(actualActor.equals(testActor));


    }



}