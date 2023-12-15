# Book Rating System

The Book Rating System is a web application that allows users to search for books, rate them, and submit reviews. It provides book details, average ratings, and reviews for each book.

## Table of Contents

- [Features](#features)
- [Technologies](#technologies)
- [Setup](#setup)
- [API Endpoints](#api-endpoints)
- [Testing](#testing)
- [TODO](#todo)

## Features

- **Book Search**: Users can search for books by title (or author name).
- **Book Rating**: Users can rate books on a scale from 1 to 5.
- **Review Submission**: Users can submit reviews for books.
- **Book Details**: The system provides detailed information about each book, including authors and languages.
- **Average Rating**: The system calculates and displays the average rating for each book.
- **Review List**: Users can view a list of reviews submitted for each book.

## Technologies

- Java
- Spring Boot
- Spring Data JPA
- H2
- Apache Commons Validator
- Maven
- RESTful API

## Setup

1. Clone the repository:

   ```bash
   git clone https://github.com/allankassio/bookrating.git

2. Navigate to the project directory:

    ```bash
    cd book-rating-system

3. Build the project:

    ```bash
    mvn clean install

4. Build the docker container:

    ```bash
    docker build -t bookrating .

5. Run the docker container:

    ```bash
    docker run -p 8080:8080 bookrating

6. Use the API in some standalone application (like Postman)

## API Endpoints

The application provides the following API endpoints:

Use http://localhost:8080 before the endpoint url.

GET /books/search?title={title}: Search for books by title.
POST /review: Create a new review.
GET /review/{bookId}: Get book details with reviews.

## Testing
To run unit tests, use the following command:

```bash
mvn test
```

## TODO
* Handle pagination of the search service.
* Implement a caching mechanism for book details. 
* Create a service that returns the top N books based on their average rating. 
* Create a service that, given a book id, returns its average rating per month.
* Provide a high-level system diagram of how you would deploy such a service in a scalable way.
