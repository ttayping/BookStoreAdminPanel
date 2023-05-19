package bookstore.admin.panel.controller;

import bookstore.admin.panel.filter.BookFilter;
import bookstore.admin.panel.model.dto.BookRequestDto;
import bookstore.admin.panel.model.dto.BookResponseDto;
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
    public ResponseEntity<Void> addBook(@RequestBody BookRequestDto bookDto) {
        bookService.addBook(bookDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    @ApiOperation("method for get all books from store")
    public ResponseEntity<List<BookResponseDto>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/filter")
    public ResponseEntity<List<BookResponseDto>> getBooks(BookFilter filter) {
        return ResponseEntity.ok(bookService.getBooks(filter));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponseDto> getBookById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateBook(@PathVariable Long id, @RequestBody BookRequestDto bookDto) {
        bookService.updateBook(id, bookDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookById(@PathVariable Long id) {
        bookService.deleteBookById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/stock/{id}")
    ResponseEntity<Integer> getStockByBookId(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.getStockByBookId(id));
    }

    @PutMapping("/stock/{id}")
    ResponseEntity<Void> updateBookStock(@PathVariable Long id, @RequestParam Integer newStock) {
        bookService.addStockByBookId(id, newStock);
        return ResponseEntity.ok().build();
    }
}
