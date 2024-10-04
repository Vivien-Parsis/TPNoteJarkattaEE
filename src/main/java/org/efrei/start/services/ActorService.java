package org.efrei.start.services;

import org.efrei.start.dto.CreateActor;
import org.efrei.start.models.Actor;
import org.efrei.start.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService {
    private final ActorRepository repository;

    @Autowired
    public ActorService(ActorRepository repository) {
        this.repository = repository;
    }

    public List<Actor> findAll(){
        return repository.findAll();
    }

    public void create(CreateActor createActor){
        Actor actor = new Actor();
        actor.setLastname(createActor.getLastname());
        actor.setFirstname(createActor.getFirstname());
        repository.save(actor);
    }

    public Actor findById(String id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

    public Actor updateById(String id, Actor actor){
        Actor oldActor = repository.findById(id).orElse(null);
        assert oldActor != null;
        oldActor.setFirstname(actor.getFirstname());
        oldActor.setLastname(actor.getLastname());
        return repository.save(oldActor);
    }
}
