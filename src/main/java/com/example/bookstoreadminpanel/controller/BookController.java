package com.example.bookstoreadminpanel.controller;

import com.example.bookstoreadminpanel.dao.entity.Book;
import com.example.bookstoreadminpanel.service.BookService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

   @PostMapping("/add")
    public Book addBook (@RequestBody Book book){
        return bookService.addBook(book);
   }


}
