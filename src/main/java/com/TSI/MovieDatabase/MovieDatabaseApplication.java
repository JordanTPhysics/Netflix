package com.TSI.MovieDatabase;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.springframework.web.bind.annotation.*;


@SpringBootApplication
@RestController
@RequestMapping("/films")

public class MovieDatabaseApplication {
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private ActorRepository actorRepository;

    public static void main(String[] args) {
        SpringApplication.run(MovieDatabaseApplication.class, args);
    }

    @GetMapping("/moviedata")
    public Movie movieData() {
        Movie starWars3 = new Movie("Revenge of the Sith", 2005, 126, "Action");
        Movie starWars4 = new Movie("A new Hope",1977,135,"Adventure");
        return starWars4;

    }

    @GetMapping("/allmovies")
    public @ResponseBody Iterable<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @PostMapping("/addMovie")
    public @ResponseBody
    String addAMovie(@RequestParam String title
            , @RequestParam int releaseYr, @RequestParam int length, @RequestParam String genre) {


        Movie savedMovie = new Movie(title, releaseYr, length, genre);
        movieRepository.save(savedMovie);
        return "Saved";
    }

    @GetMapping("/actordata")
    public Actor actorData() {
        Actor tomCruise = new Actor(1, "Tom", "Cruise");
        return tomCruise;
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
}
