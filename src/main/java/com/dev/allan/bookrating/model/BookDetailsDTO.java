package com.dev.allan.bookrating.model;

import java.util.List;
import java.util.Objects;

public class BookDetailsDTO extends BookDTO {
    private Double averageRating;
    private List<String> reviews;

    public BookDetailsDTO() {
        super();
    }

    public BookDetailsDTO(BookDTO book, Double averageRating, List<String> reviews) {
        super(book.getId(), book.getTitle(), book.getAuthors(), book.getLanguages(), book.getDownloadCount());
        this.averageRating = averageRating;
        this.reviews = reviews;
    }

    public Double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(Double averageRating) {
        this.averageRating = averageRating;
    }

    public List<String> getReviews() {
        return reviews;
    }

    public void setReviews(List<String> reviews) {
        this.reviews = reviews;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookDetailsDTO)) return false;
        if (!super.equals(o)) return false;
        BookDetailsDTO that = (BookDetailsDTO) o;
        return Objects.equals(averageRating, that.averageRating) &&
                Objects.equals(reviews, that.reviews);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), averageRating, reviews);
    }

    @Override
    public String toString() {
        return "BookDetailsDTO{" +
                "id=" + getId() +
                ", title='" + getTitle() + '\'' +
                ", authors=" + getAuthors() +
                ", languages=" + getLanguages() +
                ", downloadCount=" + getDownloadCount() +
                ", averageRating=" + averageRating +
                ", reviews=" + reviews +
                '}';
    }
}
