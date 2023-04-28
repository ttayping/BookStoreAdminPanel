package com.example.bookstoreadminpanel.controller;

import com.example.bookstoreadminpanel.dao.entity.Book;
import com.example.bookstoreadminpanel.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/show-books") // Stack Over Flow error
    public List<Book> getAllBooks (){
        return bookService.getAllBooks();
    }
    @GetMapping("/get/id")
    public Book getBookById(@RequestParam Long id){
      return bookService.getBookById(id);
    }

    @PutMapping("/update")
    public Book updateBook (@RequestBody Book book){
        return bookService.updateBook(book);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteBookById(@RequestParam Long id){
        bookService.deleteBookById(id);
    }


}
