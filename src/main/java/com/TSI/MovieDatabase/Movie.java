package com.TSI.MovieDatabase;

import javax.persistence.*;


@Entity
@Table(name = "film")
public class Movie {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "film_id")
    private int movieId;
    @Column(name = "title")
    private String title;
    @Column(name = "release_year")
    private int releaseYr;
    @Column(name = "length")
    private int length;
    @Column(name = "description")
    private String genre;


    public Movie(int movieId, String title, int releaseYr, int length, String genre) {
        this.movieId = movieId;
        this.title = title;
        this.releaseYr = releaseYr;
        this.length = length;
        this.genre = genre;
    }
    public Movie(){

    }
    public int getMovieId(){
        return movieId;
    }
    public void setMovieId(int movieId){
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseYr() {
        return releaseYr;
    }

    public void setReleaseYr(int releaseYr) {
        this.releaseYr = releaseYr;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }



    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }



    }


