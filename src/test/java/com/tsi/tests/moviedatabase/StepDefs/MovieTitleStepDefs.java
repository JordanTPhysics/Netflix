package com.tsi.tests.moviedatabase.StepDefs;

import com.TSI.MovieDatabase.Movie;
import com.TSI.MovieDatabase.MovieRepository;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieTitleStepDefs {




    Movie testMovie = new Movie(1256,"a test movie",2019,145,"test");


@Given("a movie from database")
public void aMovieFromDatabase(){

}
@When("I check the title")
    public void iCheckTheTitle(){

}
@Then("I should be told title is correct")
    public void titleIsCorrect(){
    assertEquals("a test movie", testMovie.getTitle(), "The movie title is wrong");
}
}
