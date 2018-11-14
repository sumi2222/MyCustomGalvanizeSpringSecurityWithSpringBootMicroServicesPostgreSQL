package com.galvanize.gmdb.gmdb.controller;

import com.galvanize.gmdb.gmdb.entity.Review;
import com.galvanize.gmdb.gmdb.repository.ReviewRepository;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/review")
public class ReviewController {

    ReviewRepository reviewRepository;

    public ReviewController(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @GetMapping("/ping")
    public String ping() {
        return "There is Review controller";
    }

    @GetMapping("/getReviews")
    public Iterable<Review> getReviews() {
        return this.reviewRepository.findAll();
    }

    @PostMapping("/createReview")
    public void createReviews(@RequestBody Review review) {
        this.reviewRepository.save(review);
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