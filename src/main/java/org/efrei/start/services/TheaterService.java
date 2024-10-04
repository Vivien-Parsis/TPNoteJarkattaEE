package org.efrei.start.services;

import org.efrei.start.dto.CreateTheater;
import org.efrei.start.models.Movie;
import org.efrei.start.models.Theater;
import org.efrei.start.repository.MovieRepository;
import org.efrei.start.repository.TheaterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheaterService {
    private final TheaterRepository theaterRepository;
    private final MovieRepository movieRepository;

    public TheaterService(TheaterRepository theaterRepository, MovieRepository movieRepository) {
        this.theaterRepository = theaterRepository;
        this.movieRepository = movieRepository;
    }

    public void create(CreateTheater createTheater){
        Theater theater = new Theater();
        theater.setName(createTheater.getName());
        theater.setLocation(createTheater.getLocation());
        theaterRepository.save(theater);
    }

    public void addMovie(String idTheater, String idMovie){
        Theater theater = theaterRepository.findById(idTheater).orElse(null);
        if(theater==null) return;

        Movie movie = movieRepository.findById(idMovie).orElse(null);
        if(movie==null) return;

        theater.addMovie(movie);
        theaterRepository.save(theater);
    }

    public List<Theater> findAll(){
        return theaterRepository.findAll();
    }

    public Theater findById(String id){
        return theaterRepository.findById(id).orElse(null);
    }

    public void deleteById(String id){
        Theater theater = theaterRepository.findById(id).orElse(null);
        if(theater==null) return;

        theaterRepository.deleteById(id);
    }

    public void updateById(String id, Theater newTheater){
        Theater theater = theaterRepository.findById(id).orElse(null);
        if(theater==null) return;
        theater.setLocation(newTheater.getLocation());
        theater.setName(newTheater.getName());
        theater.setMovies(newTheater.getMovies());
        theaterRepository.save(theater);
    }
}
