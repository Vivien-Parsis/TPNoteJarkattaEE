package org.efrei.start.repository;

import org.efrei.start.models.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, String> {
}
