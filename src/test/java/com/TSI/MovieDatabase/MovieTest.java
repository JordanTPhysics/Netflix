package com.TSI.MovieDatabase;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
public class MovieTest {




    @Test
    public void getIdTest(){
    Movie testMovie1 = new Movie(2054,"This movie is awesome",22910,13984,"Not Comedy");


    assertEquals(2054,testMovie1.getMovieId());
    }
    @Test
    public void getTitleTest(){
        Movie testMovie1 = new Movie();
        testMovie1.setTitle("first test movie");
        assertEquals("first test movie",testMovie1.getTitle());
    }
    @Test
    public void getReleaseYrTest(){
        Movie testMovie1 = new Movie();
        testMovie1.setReleaseYr(1);
        assertEquals(1,testMovie1.getReleaseYr());
    }
    @Test
    public void getLengthTest(){
        Movie testMovie1 = new Movie();
        testMovie1.setLength(1);
        assertEquals(1,testMovie1.getLength());
    }
    @Test
    public void getGenreTest(){
        Movie testMovie1 = new Movie();
        testMovie1.setGenre("first");
        assertEquals("first",testMovie1.getGenre());
    }
}
