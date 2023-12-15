package com.dev.allan.bookrating.service;

import com.dev.allan.bookrating.model.BookDTO;
import com.dev.allan.bookrating.model.BookDetailsDTO;
import com.dev.allan.bookrating.model.Review;
import com.dev.allan.bookrating.model.ReviewDTO;
import com.dev.allan.bookrating.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final BookService bookService;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository, BookService bookService) {
        this.reviewRepository = reviewRepository;
        this.bookService = bookService;
    }

    public void createReview(ReviewDTO reviewDTO) {
        Review review = new Review();
        review.setBookId(reviewDTO.getBookId());
        review.setRating(reviewDTO.getRating());
        review.setReview(reviewDTO.getReview());
        reviewRepository.save(review);
    }

    public BookDetailsDTO getBookDetailsWithReviews(Integer bookId) {

        // Fetch book details from Gutendex
        BookDTO bookDetails = getBookDetailsForReview(bookId);

        // Fetch reviews from the database
        List<Review> reviews = reviewRepository.findByBookId(bookId);

        // Calculate average rating
        double averageRating = reviews.stream()
                .mapToInt(Review::getRating)
                .average()
                .orElse(0.0);

        // Map reviews to their text content
        List<String> reviewTexts = reviews.stream()
                .map(Review::getReview)
                .collect(Collectors.toList());

        // Construct and return response DTO
        return new BookDetailsDTO(bookDetails, averageRating, reviewTexts);
    }

    public BookDTO getBookDetailsForReview(Integer bookId) {
        // Call the fetchBookDetailsFromGutendex method from BookService
        return bookService.fetchBookFromGutendexById(bookId);
    }
}