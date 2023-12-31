package com.dev.allan.bookrating.controller;

import com.dev.allan.bookrating.model.BookDetailsDTO;
import com.dev.allan.bookrating.model.ReviewDTO;
import com.dev.allan.bookrating.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
        if (reviewDTO.getBookId() == null) {
            return new ResponseEntity<>("bookId can not be null", HttpStatus.BAD_REQUEST);
        }
        if (reviewDTO.getRating() < 0 || reviewDTO.getRating() > 5) {
            return new ResponseEntity<>("Rating needs to be between 0 and 5", HttpStatus.BAD_REQUEST);
        }
        reviewService.createReview(reviewDTO);
        return new ResponseEntity<>("Review submitted successfully", HttpStatus.CREATED);
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<BookDetailsDTO> getBookDetailsWithReviews(@PathVariable Integer bookId) {
        BookDetailsDTO bookDetailsWithReviews = reviewService.getBookDetailsWithReviews(bookId);
        return ResponseEntity.ok(bookDetailsWithReviews);
    }
}
