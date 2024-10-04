package org.efrei.start.services;

import org.efrei.start.dto.CreateMovie;
import org.efrei.start.models.Actor;
import org.efrei.start.models.Movie;
import org.efrei.start.models.Poster;
import org.efrei.start.repository.ActorRepository;
import org.efrei.start.repository.MovieRepository;
import org.efrei.start.repository.PosterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;
    private final ActorRepository actorRepository;
    private final PosterRepository posterRepository;

    public MovieService(MovieRepository filmRepository, ActorRepository actorRepository, PosterRepository posterRepository) {
        this.movieRepository = filmRepository;
        this.actorRepository = actorRepository;
        this.posterRepository = posterRepository;
    }

    public List<Movie> findAll(){
        return movieRepository.findAll();
    }

    public Movie findById(String id){
        return movieRepository.findById(id).orElse(null);
    }

    public void deleteById(String id){
        Movie movie = movieRepository.findById(id).orElse(null);
        if(movie==null) return;
        movieRepository.deleteById(id);
    }

    public void create(CreateMovie createFilm) {
        Movie movie = new Movie();
        movie.setTitle(createFilm.getTitle());
        movie.setCategory(createFilm.getCategory());
        movieRepository.save(movie);
    }

    public void addActor(String movieId,String actorId){
        Actor actor = actorRepository.findById(actorId).orElse(null);
        if(actor==null) return;
        Movie movie = movieRepository.findById(movieId).orElse(null);
        if(movie==null) return;
        movie.addActor(actor);
        movieRepository.save(movie);
    }

    public void update(String id, Movie newMovie){
        Movie movie = movieRepository.findById(id).orElse(null);
        if(movie==null) return;

        movie.setActors(newMovie.getActors());
        movie.setCategory(newMovie.getCategory());
        movie.setTitle(newMovie.getTitle());

        movieRepository.save(movie);
    }
}
