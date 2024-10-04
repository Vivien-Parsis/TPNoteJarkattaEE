package org.efrei.start.models;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String actorId;

    private String lastname;

    private String firstname;

    public Actor(String firstname, String lastname, String actorId) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.actorId = actorId;
    }

    public Actor() {
    }

    public String getActorId() {
        return actorId;
    }

    public void setActorId(String actorId) {
        this.actorId = actorId;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
}
