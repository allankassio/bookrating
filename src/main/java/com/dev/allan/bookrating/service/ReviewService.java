package com.dev.allan.bookrating.service;

import com.dev.allan.bookrating.model.Review;
import com.dev.allan.bookrating.model.ReviewDTO;
import com.dev.allan.bookrating.repository.ReviewRepository;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public void createReview(ReviewDTO reviewDTO) {
        Review review = new Review();
        review.setBookId(reviewDTO.getBookId());
        review.setRating(reviewDTO.getRating());
        review.setReview(reviewDTO.getReview());
        reviewRepository.save(review);
    }
}