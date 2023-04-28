package com.example.bookstoreadminpanel.service;

import com.example.bookstoreadminpanel.dao.entity.Book;

import java.util.List;

public interface BookService {
    Book addBook(Book book);

    List<Book> getAllBooks();

    Book getBookById(Long id);

    Book updateBook(Long id, Book book);

    void deleteBookById(Long id);

    Book getBookByName(String name);

    Book getBookByAuthor(String authorName);

    List<Book> getBooksByLanguage(String language);
}
