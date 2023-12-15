package com.dev.allan.bookrating.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Objects;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer bookId;
    private Integer rating;
    private String review;

    public Review() {
    }

    public Review(Integer bookId, Integer rating, String review) {
        this.bookId = bookId;
        this.rating = rating;
        this.review = review;
    }

    public Long getId() {
        return id;
    }

    public Integer getBookId() {
        return bookId;
    }

    public Integer getRating() {
        return rating;
    }

    public String getReview() {
        return review;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review1 = (Review) o;
        return Objects.equals(id, review1.id) &&
                Objects.equals(bookId, review1.bookId) &&
                Objects.equals(rating, review1.rating) &&
                Objects.equals(review, review1.review);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bookId, rating, review);
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", bookId=" + bookId +
                ", rating=" + rating +
                ", review='" + review + '\'' +
                '}';
    }
}