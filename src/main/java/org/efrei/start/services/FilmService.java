package org.efrei.start.services;

import org.efrei.start.dto.CreateFilm;
import org.efrei.start.models.Film;
import org.efrei.start.repository.FilmRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {
    private final FilmRepository filmRepository;

    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public List<Film> findAll(){
        return filmRepository.findAll();
    }
    public Film findById(String id){
        return filmRepository.findById(id).orElse(null);
    }
    public void deleteById(String id){
        filmRepository.deleteById(id);
    }
    public void create(CreateFilm createFilm) {
        Film movie = new Film();
        movie.setTitle(createFilm.getTitle());
        movie.setCategory(createFilm.getCategory());
        filmRepository.save(movie);
    }
}
