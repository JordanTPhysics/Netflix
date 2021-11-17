package com.TSI.MovieDatabase.StepDefs;

import com.TSI.MovieDatabase.Movie;
import com.TSI.MovieDatabase.MovieRepository;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MovieStepDefs {

    @Autowired
    private MovieRepository movieRepository;

    private Movie testMovie;
    private List<Movie> response;
    private String actualTitle;

    @Given("the film with title {string} is in the database")
    public void theFilmIsInTheDatabase(String title){

    }
    @When("I search for film with title {string}")
    public void iSearchForFilm(String title){

    }
}
