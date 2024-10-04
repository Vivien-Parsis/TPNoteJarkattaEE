package org.efrei.start.controllers;

import org.efrei.start.dto.CreateActor;
import org.efrei.start.models.Actor;
import org.efrei.start.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actors")
public class ActorController {
    private final ActorService service;

    @Autowired
    public ActorController(ActorService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Actor>> findAll(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody CreateActor createActor){
        service.create(createActor);
        return new ResponseEntity<>(createActor,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Actor> findById(@PathVariable String id){
        Actor actor = service.findById(id);
        return actor == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(actor, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable String id){
        Actor actor = service.findById(id);
        if(actor==null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateById(@PathVariable String id, @RequestBody Actor actor){
        Actor actorSearch = service.findById(id);
        if(actorSearch==null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(service.updateById(id, actor), HttpStatus.OK);
    }
}