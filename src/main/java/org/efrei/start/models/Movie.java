package org.efrei.start.models;

import jakarta.persistence.*;
import org.efrei.start.global.Category;

import java.util.List;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String movieId;

    private String title;

    @OneToMany
    private List<Actor> actors;

    @Enumerated(EnumType.STRING)
    private Category category;

    public Movie(Category category, List<Actor> actor, String title, String movieId) {
        this.category = category;
        this.actors = actor;
        this.title = title;
        this.movieId = movieId;
    }

    public Movie() {
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public void addActor(Actor actor){
        this.actors.add(actor);
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
