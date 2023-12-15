package com.dev.allan.bookrating.controller;

import com.dev.allan.bookrating.model.ReviewDTO;
import com.dev.allan.bookrating.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/review")
@Validated
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    public ResponseEntity<String> createReview(@Valid @RequestBody ReviewDTO reviewDTO) {
        reviewService.createReview(reviewDTO);
        return new ResponseEntity<>("Review submitted successfully", HttpStatus.CREATED);
    }
}
