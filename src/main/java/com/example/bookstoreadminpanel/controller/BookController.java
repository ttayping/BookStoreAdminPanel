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

    @PutMapping("/update/{id}")
    public Book updateBook ( @PathVariable("id")  Long id,@RequestBody Book book){
        return bookService.updateBook(id, book);
    }
    @DeleteMapping("/delete")
    public void deleteBookById(@RequestParam Long id){
        bookService.deleteBookById(id);
    }
    @GetMapping("/search-by-name")
    public Book getBookByName (@RequestParam String bookName){
      return bookService.getBookByName(bookName);
    }
    @GetMapping("/search-by-authhor") // not finished
    public Book getBookByAuthor(@RequestParam String authorName){
        return bookService.getBookByAuthor(authorName);
    }
    @GetMapping("/search-by-language")
    public List<Book> getBooksByLanguage(@RequestParam String language) {
        return bookService.getBooksByLanguage(language);
    }
    }
