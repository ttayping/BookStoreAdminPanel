package bookstore.admin.panel.controller;

import bookstore.admin.panel.model.dto.BookDto;
import bookstore.admin.panel.service.BookService;
import bookstore.admin.panel.model.dto.BookRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping
    public ResponseEntity<Void> addBook(@RequestBody BookRequestDto book) {
        bookService.addBook(book);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<BookDto>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateBook(@PathVariable Long id, @RequestBody BookRequestDto bookRequestDto) {
        bookService.updateBook(id, bookRequestDto);
        return ResponseEntity.ok().build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookById(@PathVariable Long id) {
        bookService.deleteBookById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/name/{bookName}")
    public ResponseEntity<BookDto> getBookByName(@PathVariable String bookName) {
        return ResponseEntity.ok(bookService.getBookByName(bookName));
    }

    @GetMapping("/author/{author}")
    public ResponseEntity<BookDto> getBookByAuthor(@PathVariable String author) {
        return ResponseEntity.ok(bookService.getBookByAuthor(author));
    }

    @GetMapping("/language/{language}")
    public ResponseEntity<List<BookDto>> getBooksByLanguage(@PathVariable String language) {
        return ResponseEntity.ok(bookService.getBooksByLanguage(language));
    }
}
