package org.efrei.start.dto;

public class CreatePoster {
    private String url;
    private String description;
    private String movieId;

    public CreatePoster(String url, String description, String movieId) {
        this.url = url;
        this.description = description;
        this.movieId = movieId;
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

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }
}
