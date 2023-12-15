package com.dev.allan.bookrating.repository;

import com.dev.allan.bookrating.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByBookId(Integer bookId);
    // Additional query methods if needed
}
