package com.galvanize.gmdb.gmdb.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;

@Entity(name="REVIEW")
public class Review {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="REVIEW_ID")
    private long reviewId;

    @Column(name="MOVIE_ID", insertable = false, updatable = false, nullable = false)
    private long movieId;

    @Column(name="REVIEWER_ID", insertable = false, updatable = false, nullable = false)
    private long reviewerId;

    @Column(name="REVIEW_TEXT")
    private String reviewText;


    @Column(columnDefinition = "date", name="LAST_UPDATED")
    private Date lastUpdate;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "MOVIE_ID", referencedColumnName = "MOVIE_ID")
    private Movie movie;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="REVIEWER_ID", referencedColumnName = "REVIEWER_ID")
    private Reviewer reviewer;


    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Reviewer getReviewer() {
        return reviewer;
    }

    public void setReviewer(Reviewer reviewer) {
        this.reviewer = reviewer;
    }


    public long getReviewId() {
        return reviewId;
    }

    public void setReviewId(long reviewId) {
        this.reviewId = reviewId;
    }

    public long getReviewerId() {
        return reviewerId;
    }

    public void setReviewerId(long reviewerId) {
        this.reviewerId = reviewerId;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewId=" + reviewId +
                ", movieId=" + movieId +
                ", reviewerId=" + reviewerId +
                ", reviewText='" + reviewText + '\'' +
                ", lastUpdate=" + lastUpdate +
                ", movie=" + movie +
                ", reviewer=" + reviewer +
                '}';
    }
}
