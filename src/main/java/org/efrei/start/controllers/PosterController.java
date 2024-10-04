package org.efrei.start.controllers;

import org.efrei.start.dto.CreatePoster;
import org.efrei.start.models.Poster;
import org.efrei.start.services.PosterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posters")
public class PosterController {
    private final PosterService posterService;

    public PosterController(PosterService posterService) {
        this.posterService = posterService;
    }

    @GetMapping
    public ResponseEntity<List<Poster>> findAll(){
        return new ResponseEntity<>(posterService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable String id){
        Poster poster = posterService.findById(id);
        return poster == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(poster, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable String id){
        Poster poster = posterService.findById(id);
        if(poster == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<CreatePoster> create(@RequestBody CreatePoster createPoster){
        posterService.create(createPoster);
        return new ResponseEntity<>(createPoster, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Poster> updateById(@RequestBody Poster newPoster, @PathVariable String id){
        Poster poster = posterService.findById(id);
        if(poster == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        posterService.update(id, newPoster);
        return new ResponseEntity<>(posterService.findById(id), HttpStatus.CREATED);
    }
}
