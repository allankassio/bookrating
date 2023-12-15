package com.dev.allan.bookrating;

import com.dev.allan.bookrating.controller.BookController;
import com.dev.allan.bookrating.model.BookDTO;
import com.dev.allan.bookrating.model.PersonDTO;
import com.dev.allan.bookrating.model.BooksWrapper;
import com.dev.allan.bookrating.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookControllerTest {

    @InjectMocks
    private BookController bookController;

    @Mock
    private BookService bookService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSearchBooks() {
        String title = "Sample Title";
        List<PersonDTO> mockAuthors = Arrays.asList(
                new PersonDTO(1900, 1950, "Author 1"),
                new PersonDTO(1910, 1960, "Author 2")
        );
        List<String> mockLanguages = Arrays.asList("en", "pt");
        Integer downloadCount = 100;

        BookDTO mockBookA = new BookDTO(1, title, mockAuthors, mockLanguages, downloadCount);
        BookDTO mockBookB = new BookDTO(2, title, mockAuthors, mockLanguages, downloadCount);
        List<BookDTO> mockBooks = Arrays.asList(mockBookA, mockBookB);
        when(bookService.searchBooks(title)).thenReturn(List.of(mockBookA, mockBookB));

        ResponseEntity<BooksWrapper> response = bookController.searchBooks(title);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        BooksWrapper booksWrapper = response.getBody();
        assertEquals(mockBooks, Objects.requireNonNull(booksWrapper).getBooks());
    }
}
