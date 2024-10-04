package org.efrei.start.controllers;

import org.efrei.start.dto.CreateMovie;
import org.efrei.start.models.Actor;
import org.efrei.start.models.Movie;
import org.efrei.start.services.ActorService;
import org.efrei.start.services.MovieService;
import org.efrei.start.services.PosterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;
    private final PosterService posterService;
    private final ActorService actorService;

    @Autowired
    public MovieController(MovieService filmService, PosterService posterService, ActorService actorService) {
        this.movieService = filmService;
        this.posterService = posterService;
        this.actorService = actorService;
    }

    @GetMapping
    public ResponseEntity<List<Movie>> findAll() {
        return new ResponseEntity<>(movieService.findAll(),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Movie> findById(@PathVariable String id) {
        Movie film = movieService.findById(id);
        return film == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(film, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createFilm(@RequestBody CreateMovie movie){
        movieService.create(movie);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteById(String id){
        Movie film = movieService.findById(id);
        if(film == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        movieService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateById(@RequestBody Movie newMovie, @PathVariable String id){
        Movie movie = movieService.findById(id);
        if(movie == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        movieService.update(id, newMovie);
        return new ResponseEntity<>(movieService.findById(id), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}/add-actor/{actorId}")
    public ResponseEntity<Movie> addActor(@PathVariable String id, @PathVariable String actorId){
        Movie movie = movieService.findById(id);
        if(movie == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        Actor actor = actorService.findById(actorId);
        if(actor == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        movieService.addActor(id,actorId);
        return new ResponseEntity<>(movieService.findById(id), HttpStatus.CREATED);
    }
}
