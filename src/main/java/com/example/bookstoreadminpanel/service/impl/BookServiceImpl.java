package com.example.bookstoreadminpanel.service.impl;

import com.example.bookstoreadminpanel.dao.entity.Book;
import com.example.bookstoreadminpanel.dao.repository.BookRepository;
import com.example.bookstoreadminpanel.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public Book updateBook(Book book) {
        return null;
    }
}
