package com.example.lesson4_2.controller;

import com.example.lesson4_2.service.BookService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
}
