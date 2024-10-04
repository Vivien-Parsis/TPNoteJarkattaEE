package org.efrei.start.repository;

import org.efrei.start.models.Movie;
import org.efrei.start.models.Poster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PosterRepository  extends JpaRepository<Poster, String> {
}
