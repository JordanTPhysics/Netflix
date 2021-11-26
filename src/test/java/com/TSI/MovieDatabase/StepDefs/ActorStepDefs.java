package com.TSI.MovieDatabase.StepDefs;

import com.TSI.MovieDatabase.Actor;
import com.TSI.MovieDatabase.ActorRepository;



import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;





import static org.junit.Assert.assertEquals;


public class ActorStepDefs {


    int actorId;
    String firstName;
    String lastName;




    @Autowired
    ActorRepository actorRepository;




    @Given("user adds a new Actor")
    public void aNewActor() {
        Actor testActor = new Actor(actorId, "Jiminy", "Salmon");
        actorRepository.save(testActor);
        int testActorId = testActor.getActorId();
    }
    @When("the user searches for Actor ID {int}")
    public void theActorIsPutIn(int testActorId) {
        Actor actualActor = actorRepository.findById(testActorId).get();
        int actualActorId = actualActor.getActorId();
    }
    @Then("the Actor with ID {int} will be found")
    public void theActorWillBeFound(int actualActorId) {

        assertEquals("The actor was not found",200,actualActorId);
    }




    @Given("user wants to list all actors")
    public void listAllActors(){

    }
    @When("the actors are requested")
    public void getAllActors(){

    }
    @Then("all actors are returned")
    public void putAllActors(){

    }


}
