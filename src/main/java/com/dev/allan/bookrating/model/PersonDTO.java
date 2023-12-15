package com.dev.allan.bookrating.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class PersonDTO {
    @JsonProperty("birth_year")
    private Integer birthYear;
    @JsonProperty("death_year")
    private Integer deathYear;
    @JsonProperty("name")
    private String name;

    public PersonDTO() {
        // Default constructor
    }

    public PersonDTO(Integer birthYear, Integer deathYear, String name) {
        this.birthYear = birthYear;
        this.deathYear = deathYear;
        this.name = name;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public Integer getDeathYear() {
        return deathYear;
    }

    public String getName() {
        return name;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public void setDeathYear(Integer deathYear) {
        this.deathYear = deathYear;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonDTO that)) return false;
        return Objects.equals(birthYear, that.birthYear) &&
                Objects.equals(deathYear, that.deathYear) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(birthYear, deathYear, name);
    }

    @Override
    public String toString() {
        return "PersonDTO{" +
                "birth_year=" + birthYear +
                ", death_year=" + deathYear +
                ", name='" + name + '\'' +
                '}';
    }
}
