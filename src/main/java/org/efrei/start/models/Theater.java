package org.efrei.start.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Theater {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String theaterId;

    private String name;

    private String location;

    @OneToMany
    private List<Movie> movies;

    public Theater(String theaterId, String name, String location, List<Movie> movie) {
        this.theaterId = theaterId;
        this.name = name;
        this.location = location;
        this.movies = movie;
    }

    public Theater() {
    }

    public String getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(String theaterId) {
        this.theaterId = theaterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public void addMovie(Movie movie){
        this.movies.add(movie);
    }
}
