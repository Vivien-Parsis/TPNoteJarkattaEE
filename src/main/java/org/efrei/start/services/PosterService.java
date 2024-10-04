package org.efrei.start.services;

import org.efrei.start.dto.CreatePoster;
import org.efrei.start.models.Movie;
import org.efrei.start.models.Poster;
import org.efrei.start.repository.MovieRepository;
import org.efrei.start.repository.PosterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PosterService {
    private final PosterRepository posterRepository;
    private final MovieRepository movieRepository;

    public PosterService(PosterRepository posterRepository, MovieRepository movieRepository) {
        this.posterRepository = posterRepository;
        this.movieRepository = movieRepository;
    }

    public void create(CreatePoster createPoster){
        Poster poster = new Poster();
        Movie movie = movieRepository.findById(createPoster.getMovieId()).orElse(null);
        if(movie==null)return;
        poster.setDescription(createPoster.getDescription());
        poster.setUrl(createPoster.getUrl());
        poster.setMovie(movie);
        posterRepository.save(poster);
    }

    public List<Poster> findAll(){
        return posterRepository.findAll();
    }
    public Poster findById(String id){
        return posterRepository.findById(id).orElse(null);
    }

    public void deleteById(String id){
        Poster poster = posterRepository.findById(id).orElse(null);
        if(poster==null) return;
        posterRepository.deleteById(id);
    }
    public void update(String id, Poster newPoster){
        Poster poster = posterRepository.findById(id).orElse(null);
        if(poster==null) return;

        poster.setUrl(newPoster.getUrl());
        poster.setMovie(newPoster.getMovie());
        poster.setDescription(newPoster.getDescription());
        posterRepository.save(poster);
    }
}
