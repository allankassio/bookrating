package com.dev.allan.bookrating;

import com.dev.allan.bookrating.controller.ReviewController;
import com.dev.allan.bookrating.model.BookDTO;
import com.dev.allan.bookrating.model.BookDetailsDTO;
import com.dev.allan.bookrating.model.PersonDTO;
import com.dev.allan.bookrating.model.ReviewDTO;
import com.dev.allan.bookrating.service.ReviewService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ReviewControllerTest {

    private ReviewController reviewController;

    @Mock
    private ReviewService reviewService;

    @Mock
    private Validator validator;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        reviewController = new ReviewController(reviewService);
    }

    @Test
    public void testCreateReview_Success() {
        // Create a valid ReviewDTO for testing
        ReviewDTO reviewDTO = new ReviewDTO();
        reviewDTO.setBookId(1);
        reviewDTO.setRating(4);
        reviewDTO.setReview("Sample review text");

        // Mock the behavior of reviewService
        doNothing().when(reviewService).createReview(reviewDTO);

        // Mock validator to return an empty set of constraint violations
        when(validator.validate(reviewDTO)).thenReturn(Collections.emptySet());

        // Perform the POST request to create a review
        ResponseEntity<String> response = reviewController.createReview(reviewDTO);

        // Verify the response
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Review submitted successfully", response.getBody());

        // Verify that the reviewService's createReview method was called
        verify(reviewService, times(1)).createReview(reviewDTO);
    }

    @Test
    public void testCreateReview_ValidationFailure() {
        // Create an invalid ReviewDTO for testing (missing bookId)
        ReviewDTO reviewDTO = new ReviewDTO();
        reviewDTO.setRating(4);
        reviewDTO.setReview("Sample review text");

        // Mock validator to return a set of constraint violations
        Set<ConstraintViolation<ReviewDTO>> violations = new HashSet<>();
        // Simulate a constraint violation for the missing bookId
        ConstraintViolation<ReviewDTO> violation = mock(ConstraintViolation.class);
        when(violation.getMessage()).thenReturn("bookId must not be null");
        violations.add(violation);

        when(validator.validate(reviewDTO)).thenReturn(violations);

        // Perform the POST request to create a review
        ResponseEntity<String> response = reviewController.createReview(reviewDTO);

        // Verify the response status code (should be BAD_REQUEST due to validation failure)
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }


    @Test
    public void testGetBookDetailsWithReviews_Success() {
        // Mock a BookDetailsDTO for testing
        String title = "Sample Title";
        List<PersonDTO> mockAuthors = Arrays.asList(
                new PersonDTO(1900, 1950, "Author 1"),
                new PersonDTO(1910, 1960, "Author 2")
        );
        List<String> mockLanguages = Arrays.asList("en", "pt");
        Integer downloadCount = 100;

        BookDTO book = new BookDTO(1, title, mockAuthors, mockLanguages, downloadCount);
        BookDetailsDTO bookDetailsDTO = new BookDetailsDTO(book, 0.0, Collections.emptyList());
        Integer bookId = 1;

        // Mock the behavior of reviewService
        when(reviewService.getBookDetailsWithReviews(bookId)).thenReturn(bookDetailsDTO);

        // Perform the GET request to retrieve book details with reviews
        ResponseEntity<BookDetailsDTO> response = reviewController.getBookDetailsWithReviews(bookId);

        // Verify the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(bookDetailsDTO, response.getBody());

        // Verify that the reviewService's getBookDetailsWithReviews method was called
        verify(reviewService, times(1)).getBookDetailsWithReviews(bookId);
    }
}