package com.galvanize.gmdb.gmdb.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;


@Entity(name="REVIEWER")
public class Reviewer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="REVIEWER_ID")
    private long reviewerId;

    @Column(name="USERNAME")
    private String userName;

    @Column(columnDefinition = "date", name="DATE_JOINED")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateJoined;

    @Column(name="NUMBER_OF_REVIEWS")
    private long number_of_reviews;

    @OneToMany(mappedBy="reviewer", targetEntity= Review.class, cascade = CascadeType.ALL)
    private Collection<Reviewer> reviewers = new ArrayList<>();

    public long getReviewerId() {
        return reviewerId;
    }

    public void setReviewerId(long reviewerId) {
        this.reviewerId = reviewerId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(Date dateJoined) {
        this.dateJoined = dateJoined;
    }

    public long getNumber_of_reviews() {
        return number_of_reviews;
    }

    public void setNumber_of_reviews(long number_of_reviews) {
        this.number_of_reviews = number_of_reviews;
    }
}
