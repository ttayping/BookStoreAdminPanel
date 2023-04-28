package com.example.bookstoreadminpanel.controller;

import com.example.bookstoreadminpanel.dao.entity.Author;
import com.example.bookstoreadminpanel.service.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/author")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/all")
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/get")
    public Optional<Author> getAuthorById(@RequestParam Long id) {
        return authorService.getAuthorById(id);
    }

    @PostMapping("/add")
    public Author addAuthor(@RequestBody Author author) {
        return authorService.addAuthor(author);
    }

    @DeleteMapping("/delete-by-id")
    public void deleteAuthorById(@RequestParam Long id) {
        authorService.deleteAuthorById(id);
    }

    @PutMapping("/update")
    public Author updateAuthor(@RequestBody Author author) {
        return authorService.updateAuthor(author);
    }
}
