package org.efrei.start.models;


import jakarta.persistence.*;

@Entity
@Table(name = "acteur")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String lastname;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Film movie_id;

    private String firstname;

    public Actor(String firstname, String name, Film movieId) {
        this.firstname = firstname;
        this.lastname = name;
        movie_id = movieId;
    }

    public Actor() {

    }

    public String getLastName() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Film getMovie_id() {
        return movie_id;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setMovie_id(Film movie_id) {
        this.movie_id = movie_id;
    }
}
