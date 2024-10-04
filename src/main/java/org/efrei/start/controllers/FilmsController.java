package org.efrei.start.controllers;

import org.efrei.start.dto.CreateFilm;
import org.efrei.start.models.Actor;
import org.efrei.start.models.Film;
import org.efrei.start.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class FilmsController {
    private final FilmService filmService;

    @Autowired
    public FilmsController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping
    public ResponseEntity<List<Film>> findAll() {
        return new ResponseEntity<>(filmService.findAll(),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Film> findById(String id) {
        Film film = filmService.findById(id);
        return film == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(film, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createFilm(@RequestBody CreateFilm film){
        filmService.create(film);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteById(String id){
        Film film = filmService.findById(id);
        if(film == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        filmService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
