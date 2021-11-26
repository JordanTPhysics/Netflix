package com.TSI.MovieDatabase.StepDefs;

import com.TSI.MovieDatabase.Movie;
import com.TSI.MovieDatabase.MovieRepository;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Optional;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class MovieStepDefs {

    @Autowired
    private MovieRepository movieRepository;
    private Movie descTestMovie;
    //private String testDescription = movieRepository.findById(25).get().getDescription();
    private int movieId;




    //Update operation



    @Given("a movie with a description and ID {int}")
    public void movieWithDescription(int movieId){
        Movie descTestMovie = movieRepository.findById(movieId).get();

    }
    @When("I change the description of movie {int}")
    public void changeTheDescription(int movieId){
        Movie descTestMovie = movieRepository.findById(movieId).get();
        descTestMovie.setDescription("This movie is cool and awesome and like, really sick bro.");

    }
    @Then("the movie will be updated")
    public void updateMovie(){

    assertNotEquals(descTestMovie.getDescription(),"A Thoughtful Display of a Woman And a Astronaut who must Battle a Robot in Berlin");

    }


    //Delete operation

    @Given("an unused movie with ID {int} in database")
    public void unusedMovie(int movieId){

        Movie testMovie = movieRepository.findById(movieId).get();

    }


    @When("the user deletes the movie with ID {int}")
    public void deleteMovie(int movieId) {

         movieRepository.deleteById(movieId);
    }


    @Then("the movie ID {int} will not be found")
    public void movieNotFound(int movieId){

        assertEquals("The film is still in the database", false, movieRepository.findById(movieId).isPresent());
    }
}

