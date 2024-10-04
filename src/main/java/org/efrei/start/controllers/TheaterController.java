package org.efrei.start.controllers;

import org.efrei.start.dto.CreateTheater;
import org.efrei.start.models.Movie;
import org.efrei.start.models.Theater;
import org.efrei.start.services.MovieService;
import org.efrei.start.services.TheaterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theaters")
public class TheaterController {
    private final TheaterService theaterService;
    private final MovieService movieService;

    public TheaterController(TheaterService theaterService, MovieService movieService) {
        this.theaterService = theaterService;
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<List<Theater>> findAll(){
        return new ResponseEntity<>(theaterService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable String id){
        Theater theater = theaterService.findById(id);
        return theater == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(theater, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteById(@PathVariable String id){
        Theater theater = theaterService.findById(id);
        if(theater == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<CreateTheater> create(@RequestBody CreateTheater createTheater){
        theaterService.create(createTheater);
        return new ResponseEntity<>(createTheater, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Theater> updateById(@RequestBody Theater newTheater, @PathVariable String id){
        Theater theater = theaterService.findById(id);
        if(theater == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        theaterService.updateById(id, newTheater);
        return new ResponseEntity<>(theaterService.findById(id), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}/add-movie/{movieId}")
    public ResponseEntity<Theater> addMovie(@PathVariable String id, @PathVariable String movieId){
        Theater theater = theaterService.findById(id);
        if(theater == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        Movie movie = movieService.findById(movieId);
        if(movie == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        theaterService.addMovie(id, movieId);
        return new ResponseEntity<>(theaterService.findById(id), HttpStatus.CREATED);
    }
}
