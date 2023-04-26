package com.example.lesson4_2.service.impl;

import com.example.lesson4_2.dao.repository.BookRepository;
import com.example.lesson4_2.service.BookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
}
