package org.efrei.start.models;

import jakarta.persistence.*;

@Entity
public class Poster {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String idPoster;

    @OneToOne
    private Movie movie;

    private String url;
    private String description;

    public Poster(String idPoster, Movie movie, String url, String description) {
        this.idPoster = idPoster;
        this.movie = movie;
        this.url = url;
        this.description = description;
    }

    public Poster() {
    }

    public String getIdPoster() {
        return idPoster;
    }

    public void setIdPoster(String idPoster) {
        this.idPoster = idPoster;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
