package com.tsi.tests.moviedatabase;


import com.TSI.MovieDatabase.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieTest {



    @Test
     public void isTheTitleCorrect(){
        Movie movie = new Movie("moviename",100,123,"Action");
        assertEquals("moviename",movie.getTitle(),"The title is wrong");
    }
}
