package bookstore.admin.panel.service;

import bookstore.admin.panel.dao.entity.Author;
import bookstore.admin.panel.dao.repository.AuthorRepository;
import bookstore.admin.panel.dao.repository.BookRepository;
import bookstore.admin.panel.exception.NotFoundException;
import bookstore.admin.panel.mapper.UniversalMapper;
import bookstore.admin.panel.model.dto.AuthorDto;
import bookstore.admin.panel.model.dto.AuthorGetDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    UniversalMapper mapper = UniversalMapper.MAPPER;

    public List<AuthorGetDto> getAllAuthors() {
        return mapper.toAuthorGetDtoList(authorRepository.findAll());
    }

    public AuthorGetDto getAuthorById(Long id) {
        Author foundAuthor = authorRepository.findById(id).orElseThrow(()
                -> new NotFoundException("404", "book didn't found which you search. Please, change search parameters"));
        return mapper.toAuthorGetDto(foundAuthor);
    }

    public void addAuthor(AuthorDto authorDto) {
        Author author = mapper.toAuthorEntity(authorDto);
        author.setBooks(bookRepository.findAllByIdIn(authorDto.getBookIdList()));
        System.out.println(author.getBooks());
        authorRepository.save(author);
    }

    public void deleteAuthorById(Long id) {
        authorRepository.deleteById(id);
    }

    public void updateAuthor(Long id, AuthorDto authorDto) {
        Author author = authorRepository.findById(id).orElseThrow(
                () -> new NotFoundException("code404", "author didnt found. Please change search parameters"));
        author.setId(id);
        author.setName(authorDto.getAuthorName());
        author.setBooks(bookRepository.findAllByIdIn(authorDto.getBookIdList()));
        authorRepository.save(author);
    }
}
