package bookstore.admin.panel.service;

import bookstore.admin.panel.dao.entity.Author;
import bookstore.admin.panel.dao.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;


    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Optional<Author> getAuthorById(Long id) {
        return authorRepository.findById(id);
    }

    public Author addAuthor(Author author) {
        return authorRepository.save(author);
    }

    public void deleteAuthorById(Long id) {
        authorRepository.deleteById(id);
    }

    public Author updateAuthor(Long id, Author author) {
        Optional<Author> resultAuthor = authorRepository.findById(id);
        if(resultAuthor.isPresent()){
            resultAuthor.get().setName(author.getName());
            resultAuthor.get().setBooks(author.getBooks());
        }
        return authorRepository.save(resultAuthor.get());
    }
}
