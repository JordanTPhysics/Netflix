package com.tsi.tests.moviedatabase;


import com.TSI.MovieDatabase.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieTest {

    Movie movie = new Movie(1001,"moviename",100,123,"Action");

    @Test
     public void isTheTitleCorrect(){

        assertEquals("moviename",movie.getTitle(),"The title is wrong");
    }
    @Test
    public void isTheReleaseYrCorrect(){
        assertEquals(100, movie.getReleaseYr(),"The release year is incorrect");
    }
    @Test
    public void isTheLengthCorrect(){
        assertEquals(123,movie.getLength(),"The length is incorrect");
    }
    @Test
    public void isTheGenreCorrect(){
        assertEquals("Action",movie.getGenre(),"The genre is incorrect");
    }
}
