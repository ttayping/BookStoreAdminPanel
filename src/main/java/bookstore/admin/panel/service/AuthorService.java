package bookstore.admin.panel.service;

import bookstore.admin.panel.dao.entity.Author;
import bookstore.admin.panel.dao.entity.Book;
import bookstore.admin.panel.dao.repository.AuthorRepository;
import bookstore.admin.panel.dao.repository.BookRepository;
import bookstore.admin.panel.exception.BadRequestException;
import bookstore.admin.panel.exception.Error;
import bookstore.admin.panel.exception.NotFoundException;
import bookstore.admin.panel.mapper.UniversalMapper;
import bookstore.admin.panel.model.dto.AuthorDto;
import bookstore.admin.panel.model.dto.AuthorRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    UniversalMapper mapper = UniversalMapper.MAPPER;

    public List<AuthorRequestDto> getAllAuthors() {
        List<Author> authors =authorRepository.findAll();
        return mapper.toAuthorRequestDtoList(authors);
    }

    public AuthorRequestDto getAuthorById(Long id) {
        if (Objects.isNull(id)) {
            throw new BadRequestException(Error.BAD_REQUEST_ERROR_CODE, Error.BAD_REQUEST_ERROR_MESSAGE);
        }
        Author foundAuthor = authorRepository.findById(id).orElseThrow(()
                -> new NotFoundException(Error.NOT_FOUND_ERROR_CODE,
                Error.AUTHOR_NOT_FOUND_ERROR_MESSAGE));
        return mapper.toAuthorRequestDto(foundAuthor);
    }

    public void addAuthor(AuthorDto authorDto) {
        if (Objects.isNull(authorDto)) {
            throw new BadRequestException(Error.BAD_REQUEST_ERROR_CODE, Error.BAD_REQUEST_ERROR_MESSAGE);
        }
        Author author = mapper.toAuthorEntity(authorDto);
        if (Objects.isNull(author.getName())) {
            throw new BadRequestException(Error.BAD_REQUEST_ERROR_CODE, Error.BAD_REQUEST_ERROR_MESSAGE);
        }
        List<Book> books = bookRepository.findAllByIdIn(authorDto.getBookIdList());
        if (Objects.nonNull(books)) {
            author.setBooks(books);
        }
        authorRepository.save(author);
    }

    public void deleteAuthorById(Long id) {
        if (Objects.isNull(id)) {
            throw new BadRequestException(Error.BAD_REQUEST_ERROR_CODE, Error.BAD_REQUEST_ERROR_MESSAGE);
        }
        authorRepository.findById(id).orElseThrow(
                () -> new NotFoundException(Error.NOT_FOUND_ERROR_CODE,
                        Error.AUTHOR_NOT_FOUND_ERROR_MESSAGE));
        authorRepository.deleteById(id);
    }

    public void updateAuthor(Long id, AuthorDto authorDto) {
        if (Objects.isNull(id)||Objects.isNull(authorDto)){
            throw new BadRequestException(Error.BAD_REQUEST_ERROR_CODE,Error.BAD_REQUEST_ERROR_MESSAGE);
        }
        Author author = authorRepository.findById(id).orElseThrow(
                () -> new NotFoundException(Error.NOT_FOUND_ERROR_CODE,
                        Error.AUTHOR_NOT_FOUND_ERROR_MESSAGE));
        author.setName(authorDto.getAuthorName());
        author.setBooks(bookRepository.findAllByIdIn(authorDto.getBookIdList()));
        authorRepository.save(author);
    }
}
