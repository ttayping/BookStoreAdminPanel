package com.example.bookstoreadminpanel.service;

import com.example.bookstoreadminpanel.dao.entity.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> getAllAuthors();

    Optional<Author> getAuthorById(Long id);

    Author addAuthor(Author author);

    void deleteAuthorById(Long id);

    Author updateAuthor(Author author);
}
