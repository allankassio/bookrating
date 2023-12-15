package com.dev.allan.bookrating.repository;

import com.dev.allan.bookrating.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    // Additional query methods if needed
}
