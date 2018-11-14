package com.galvanize.gmdb.gmdb.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity(name="MOVIE")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="MOVIE_ID")
    private Long movieId;

    @Column(name="MOVIE_TITLE")
    private String title;

    @Column(columnDefinition = "date", name="MOVIE_YEAR_OF_RELEASE")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date yearOfRelease;

    @Column(name="GENRE")
    private String genre;

    @Column(name="MOVIE_RUNTIME")
    private int runtime;

    @OneToMany(mappedBy="movie", targetEntity= Review.class, cascade = CascadeType.ALL)
    private List<Review> reviews= new ArrayList<>();


    public Long getMovieId() {
        return movieId;
    }

    public String getTitle() {
        return title;
    }

    public Date getYearOfRelease() {
        return yearOfRelease;
    }

    public String getGenre() {
        return genre;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYearOfRelease(Date yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }
}





