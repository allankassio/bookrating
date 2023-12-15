package com.dev.allan.bookrating.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

public class BookDTO {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("authors")
    private List<PersonDTO> authors;
    @JsonProperty("languages")
    private List<String> languages;
    @JsonProperty("download_count")
    private Integer downloadCount;

    public BookDTO() {
        // Default constructor
    }

    public BookDTO(Integer id, String title, List<PersonDTO> authors, List<String> languages, Integer downloadCount) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.languages = languages;
        this.downloadCount = downloadCount;
    }

    // Getters
    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<PersonDTO> getAuthors() {
        return authors;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public Integer getDownloadCount() {
        return downloadCount;
    }

    // Setters
    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthors(List<PersonDTO> authors) {
        this.authors = authors;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public void setDownloadCount(Integer download_count) {
        this.downloadCount = download_count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookDTO bookDTO)) return false;
        return Objects.equals(id, bookDTO.id) &&
                Objects.equals(title, bookDTO.title) &&
                Objects.equals(authors, bookDTO.authors) &&
                Objects.equals(languages, bookDTO.languages) &&
                Objects.equals(downloadCount, bookDTO.downloadCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, authors, languages, downloadCount);
    }

    @Override
    public String toString() {
        return "BookDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", authors=" + authors +
                ", languages=" + languages +
                ", download_count=" + downloadCount +
                '}';
    }
}