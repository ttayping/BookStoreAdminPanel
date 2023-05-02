package bookstore.admin.panel.controller;

import bookstore.admin.panel.model.dto.BookDto;
import bookstore.admin.panel.model.enums.Language;
import bookstore.admin.panel.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
@Api(value = "book api")
public class BookController {
    private final BookService bookService;

    @PostMapping
    @ApiOperation("method for add new book to store")
    public ResponseEntity<Void> addBook(@RequestBody BookDto bookDto) {
        bookService.addBook(bookDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    @ApiOperation("method for get all books from store")
    public ResponseEntity<List<BookDto>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateBook(@PathVariable Long id, @RequestBody BookDto bookDto) {
        bookService.updateBook(id, bookDto);
        return ResponseEntity.ok().build();

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookById(@PathVariable Long id) {
        bookService.deleteBookById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/name/{bookName}")
    public ResponseEntity<List<BookDto>> getBookByName(@PathVariable String bookName) {
        return ResponseEntity.ok(bookService.getBookByName(bookName));
    }

    @GetMapping("/author/{author}")
    public ResponseEntity<List<BookDto>> getBooksByAuthor(@PathVariable String authorName) {
        return ResponseEntity.ok(bookService.getBooksByAuthor(authorName));
    }

    @GetMapping("/language/{language}")
    public ResponseEntity<List<BookDto>> getBooksByLanguage(@PathVariable Language language) {
        return ResponseEntity.ok(bookService.getBooksByLanguage(language));
    }

}
