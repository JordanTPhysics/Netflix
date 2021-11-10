package com.TSI.MovieDatabase;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.springframework.web.bind.annotation.*;


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
        return firstName + lastName + "Saved";
    }
    @DeleteMapping("/deleteActor")
    public @ResponseBody
        String deleteAnActor(@RequestParam int actorId) {

        // Actor deleteActor = ActorRepository.deleteById(actorId);

        return actorId + "deleted";

    }
}
