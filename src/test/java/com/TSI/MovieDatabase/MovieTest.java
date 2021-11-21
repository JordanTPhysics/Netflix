package com.TSI.MovieDatabase;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MovieTest {




    @Test
    void getIdTest(){
    Movie testMovie1 = new Movie();
    testMovie1.setMovieId(2054);
    assertEquals(2054,testMovie1.getMovieId());
    }
    @Test
    void getTitleTest(){
        Movie testMovie1 = new Movie();
        testMovie1.setTitle("first test movie");
        assertEquals("first test movie",testMovie1.getTitle());
    }
    @Test
    void getReleaseYrTest(){
        Movie testMovie1 = new Movie();
        testMovie1.setReleaseYr(1);
        assertEquals(1,testMovie1.getReleaseYr());
    }
    @Test
    void getLengthTest(){
        Movie testMovie1 = new Movie();
        testMovie1.setLength(1);
        assertEquals(1,testMovie1.getLength());
    }
    @Test
    void getDescriptionTest(){
        Movie testMovie1 = new Movie();
        testMovie1.setDescription("first");
        assertEquals("first",testMovie1.getDescription());
    }

}
