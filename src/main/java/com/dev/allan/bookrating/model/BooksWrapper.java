package com.dev.allan.bookrating.model;

import java.util.List;
import java.util.Objects;

public class BooksWrapper {
    private List<BookDTO> books;

    public BooksWrapper(List<BookDTO> books) {
        this.books = books;
    }

    public List<BookDTO> getBooks() {
        return books;
    }

    public void setBooks(List<BookDTO> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BooksWrapper that = (BooksWrapper) o;
        return Objects.equals(books, that.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(books);
    }

    @Override
    public String toString() {
        return "BooksWrapper{" +
                "books=" + books +
                '}';
    }
}
