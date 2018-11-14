package com.galvanize.gmdb.gmdb.controller;

import com.galvanize.gmdb.gmdb.entity.Review;
import com.galvanize.gmdb.gmdb.entity.Reviewer;
import com.galvanize.gmdb.gmdb.repository.ReviewRepository;
import com.galvanize.gmdb.gmdb.repository.ReviewerRepository;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/reviewer")
public class ReviewerController {

    ReviewerRepository reviewerRepository;

    public ReviewerController(ReviewerRepository reviewerRepository) {
        this.reviewerRepository = reviewerRepository;
    }

    @GetMapping("/ping")
    public String ping() {
        return "There is Review controller";
    }

    @GetMapping("/getReviewers")
    public Iterable<Reviewer> getMovies() {
        return this.reviewerRepository.findAll();
    }

    @PostMapping("/createReviewer")
    public void create(@RequestBody Reviewer reviewer) {
        this.reviewerRepository.save(reviewer);
    }


    @PutMapping("/updateReviewer")
    public Reviewer update(@RequestBody Reviewer reviewer) {
        return this.reviewerRepository.save(reviewer);
    }

    @DeleteMapping("/deleteReviewer/{reviewerId}")
    public void delete(@PathVariable("reviewerId") Long reviewerId) {
        this.reviewerRepository.deleteById(reviewerId);
    }
}