package com.dev.allan.bookrating.service;

import com.dev.allan.bookrating.model.BookDTO;
import com.dev.allan.bookrating.model.GutendexResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class BookService {

    private final RestTemplate restTemplate;

    @Value("${gutendex.api.url}")
    private String apiUrl;

    public BookService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public List<BookDTO> searchBooks(String title) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(apiUrl)
                .queryParam("search", title);
        ResponseEntity<GutendexResponseDTO> response = restTemplate.getForEntity(
                builder.toUriString(),
                GutendexResponseDTO.class
        );
        return Objects.requireNonNull(response.getBody()).getResults();
    }

    public BookDTO fetchBookFromGutendexById(Integer bookId) {
        String url = apiUrl + "/" + bookId;
        ResponseEntity<BookDTO> response = restTemplate.getForEntity(url, BookDTO.class);
        if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
            return response.getBody();
        } else {
            throw new RuntimeException("Failed to fetch book details from Gutendex");
        }
    }
}
