package com.dev.allan.bookrating.service;

import com.dev.allan.bookrating.model.BookDTO;
import com.dev.allan.bookrating.model.GutendexResponseDTO;
import org.springframework.boot.web.client.RestTemplateBuilder;
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
    private final String apiUrl = "https://gutendex.com/books"; // Gutendex API URL

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
}
