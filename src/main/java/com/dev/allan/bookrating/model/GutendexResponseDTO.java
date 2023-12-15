package com.dev.allan.bookrating.model;

import java.util.List;
import java.util.Objects;

public class GutendexResponseDTO {
    private int count;
    private String next;
    private String previous;
    private List<BookDTO> results;

    public GutendexResponseDTO() {
    }

    public GutendexResponseDTO(int count, String next, String previous, List<BookDTO> results) {
        this.count = count;
        this.next = next;
        this.previous = previous;
        this.results = results;
    }

    public int getCount() {
        return count;
    }

    public String getNext() {
        return next;
    }

    public String getPrevious() {
        return previous;
    }

    public List<BookDTO> getResults() {
        return results;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public void setResults(List<BookDTO> results) {
        this.results = results;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GutendexResponseDTO that = (GutendexResponseDTO) o;
        return count == that.count &&
                Objects.equals(next, that.next) &&
                Objects.equals(previous, that.previous) &&
                Objects.equals(results, that.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(count, next, previous, results);
    }

    @Override
    public String toString() {
        return "GutendexResponseDTO{" +
                "count=" + count +
                ", next='" + next + '\'' +
                ", previous='" + previous + '\'' +
                ", results=" + results +
                '}';
    }
}
