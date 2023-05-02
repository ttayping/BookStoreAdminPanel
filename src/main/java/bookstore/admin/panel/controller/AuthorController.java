package bookstore.admin.panel.controller;

import bookstore.admin.panel.model.dto.AuthorDto;
import bookstore.admin.panel.model.dto.AuthorGetDto;
import bookstore.admin.panel.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping
    public ResponseEntity<List<AuthorGetDto>> getAllAuthors() {
        return ResponseEntity.ok(authorService.getAllAuthors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorGetDto> getAuthorById(@PathVariable Long id) {
        return ResponseEntity.ok(authorService.getAuthorById(id));
    }

    @PostMapping
    public ResponseEntity<Void> addAuthor(@RequestBody AuthorDto authorDto) {
         authorService.addAuthor(authorDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthorById(@PathVariable Long id) {
        authorService.deleteAuthorById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateAuthor(@PathVariable Long id, @RequestBody AuthorDto authorDto) {
        authorService.updateAuthor(id, authorDto);
        return ResponseEntity.ok().build();

    }
}
