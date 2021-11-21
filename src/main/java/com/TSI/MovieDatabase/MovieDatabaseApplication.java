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
    @GetMapping("/allMovies")
    public @ResponseBody Iterable<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @PostMapping("/addMovie")
    public @ResponseBody
    String addAMovie(@RequestParam int movieId, @RequestParam String title
            , @RequestParam int releaseYr, @RequestParam int length, @RequestParam String description) {


        Movie savedMovie = new Movie(movieId, title, releaseYr, length, description);
        movieRepository.save(savedMovie);
        return "Saved";
    }
    @GetMapping("/allActors")
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
            return "Movie "+  movieId + " deleted";
        } else {
            throw new NullValueException("Movie with Id: " + movieId + "not found" );
        }
    }
    @PutMapping("/updateMovie")
    public @ResponseBody
    String updateMovie(@RequestParam int movieId, @RequestParam String title
            , @RequestParam int releaseYr, @RequestParam int length, @RequestParam String description){
        Movie updateMovie =  movieRepository.findById(movieId).get();
        updateMovie.setDescription(description);
        updateMovie.setLength(length);
        updateMovie.setTitle(title);
        updateMovie.setReleaseYr(releaseYr);

        return "movie" + movieId + "has been updated";
    }
    @PutMapping("/updateActor")
    public @ResponseBody String updateActor(@RequestParam int actorId, @RequestParam String firstName, @RequestParam String lastName){
        Actor updateActor = actorRepository.findById(actorId).get();
        updateActor.setFirstName(firstName);
        updateActor.setLastName(lastName);

        return "actor"+actorId+"has been updated";
    }
}
