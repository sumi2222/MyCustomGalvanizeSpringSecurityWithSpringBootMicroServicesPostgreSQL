package com.galvanize.gmdb.gmdb.controller;

import com.galvanize.gmdb.gmdb.entity.Review;
import com.galvanize.gmdb.gmdb.repository.MovieRepository;
import com.galvanize.gmdb.gmdb.repository.ReviewRepository;
//import org.slf4j.LoggerFactory;
import com.galvanize.gmdb.gmdb.repository.ReviewerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/review")
public class ReviewController {
    private static Logger LOGGER = LoggerFactory.getLogger(ReviewController.class);

    ReviewRepository reviewRepository;

    @Autowired
    MovieRepository movieRepository;
    @Autowired
    ReviewerRepository reviewerRepository;

    public ReviewController(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @GetMapping("/ping")
    public String ping() {
        return "There is Review controller";
    }

    @GetMapping("/getReviews")
    public Iterable<Review> getReviews( ) {
        return this.reviewRepository.findAll();
    }

    @PostMapping("/createReview")
    public Review createReviews(@RequestBody Review review) {
        LOGGER.info("Review is: {}", review.toString());
        review.setMovie(movieRepository.findById(review.getMovieId()).get());
        review.setReviewer(reviewerRepository.findById(review.getReviewerId()).get());
        return this.reviewRepository.save(review);
    }


    @PutMapping("/updateReview")
    public Review updateReviews(@RequestBody Review review) {
        return this.reviewRepository.save(review);
    }

    @DeleteMapping("/deleteReview/{reviewId}")
    public void deleteReviews(@PathVariable("reviewId") Long reviewId) {
        this.reviewRepository.deleteById(reviewId);
    }
}