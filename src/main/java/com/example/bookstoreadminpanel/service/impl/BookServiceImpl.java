package com.example.bookstoreadminpanel.service.impl;

import com.example.bookstoreadminpanel.dao.entity.Book;
import com.example.bookstoreadminpanel.dao.repository.BookRepository;
import com.example.bookstoreadminpanel.service.BookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }
}
