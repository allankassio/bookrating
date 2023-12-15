package com.dev.allan.bookrating.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

public class ReviewDTO {
    @NotNull(message = "bookId must not be null")
    private Integer bookId;

    @NotNull
    @Min(0)
    @Max(5)
    private Integer rating;

    @NotNull
    @Size(min = 1, max = 1024)
    private String review;

    public Integer getBookId() {
        return bookId;
    }

    public Integer getRating() {
        return rating;
    }

    public String getReview() {
        return review;
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
        if (!(o instanceof ReviewDTO that)) return false;
        return Objects.equals(bookId, that.bookId) &&
                Objects.equals(rating, that.rating) &&
                Objects.equals(review, that.review);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, rating, review);
    }

    @Override
    public String toString() {
        return "ReviewDTO{" +
                "bookId=" + bookId +
                ", rating=" + rating +
                ", review='" + review + '\'' +
                '}';
    }
}