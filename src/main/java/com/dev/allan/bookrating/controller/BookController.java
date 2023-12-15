package com.dev.allan.bookrating.controller;

import com.dev.allan.bookrating.model.BookDTO;
import com.dev.allan.bookrating.model.BooksWrapper;
import com.dev.allan.bookrating.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/search")
    public ResponseEntity<BooksWrapper> searchBooks(@RequestParam String title) {
        List<BookDTO> books = bookService.searchBooks(title);
        BooksWrapper booksWrapper = new BooksWrapper(books);
        return ResponseEntity.ok(booksWrapper);
    }
}
