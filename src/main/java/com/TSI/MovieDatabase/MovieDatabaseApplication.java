package com.TSI.MovieDatabase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.*;
import software.amazon.ion.NullValueException;

import java.util.Optional;


@SpringBootApplication
@RestController
@ResponseBody
@RequestMapping("/films")
public class MovieDatabaseApplication {
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private ActorRepository actorRepository;

    public static void main(String[] args) {
        SpringApplication.run(MovieDatabaseApplication.class, args);
    }

// CRUD OPERATIONS
    @GetMapping("/allmovies")
    public @ResponseBody Iterable<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @PostMapping("/addMovie")
    public @ResponseBody
    String addAMovie(@RequestParam int movieId, @RequestParam String title
            , @RequestParam int releaseYr, @RequestParam int length, @RequestParam String genre) {


        Movie savedMovie = new Movie(movieId, title, releaseYr, length, genre);
        movieRepository.save(savedMovie);
        return "Saved";
    }
    @GetMapping("/allactors")
    public @ResponseBody Iterable<Actor> getAllActors() {
        return actorRepository.findAll();
    }

    @PostMapping("/addActor")
    public @ResponseBody
    String addAnActor(@RequestParam int actorId, @RequestParam String firstName, @RequestParam String lastName)
    {
        Actor savedActor = new Actor(actorId, firstName, lastName);
        actorRepository.save(savedActor);
        return "Saved";
    }
    @DeleteMapping("/deleteActor")
    public @ResponseBody
        String deleteAnActor(@PathVariable int actorId) {

         Optional<Actor> deleteActor =  actorRepository.findById(actorId);
         if(deleteActor.isPresent()) {
             actorRepository.deleteById(actorId);
             return "Actor "+ + actorId + " deleted";
         } else {
             throw new NullValueException("Actor with Id: " + actorId + "not found" );
         }
    }
    @DeleteMapping("/deleteMovie")
    public @ResponseBody
    String deleteAMovie(@PathVariable int movieId) {

        Optional<Movie> deleteMovie =  movieRepository.findById(movieId);
        if(deleteMovie.isPresent()) {
            movieRepository.deleteById(movieId);
            return "Movie "+ + movieId + " deleted";
        } else {
            throw new NullValueException("Movie with Id: " + movieId + "not found" );
        }
    }
}
