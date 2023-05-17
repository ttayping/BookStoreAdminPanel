package bookstore.admin.panel.service;

import bookstore.admin.panel.dao.entity.Author;
import bookstore.admin.panel.dao.entity.Book;
import bookstore.admin.panel.dao.repository.AuthorRepository;
import bookstore.admin.panel.dao.repository.BookRepository;
import bookstore.admin.panel.exception.BadRequestException;
import bookstore.admin.panel.exception.Error;
import bookstore.admin.panel.exception.NotFoundException;
import bookstore.admin.panel.mapper.AuthorMapper;
import bookstore.admin.panel.mapper.Mapper;
import bookstore.admin.panel.model.dto.AuthorDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    AuthorMapper authorMapper = AuthorMapper.AUTHOR_MAPPER;
    private static final Mapper mapper = Mapper.MAPPER;

    public List<AuthorDto> getAllAuthors() {
        List<Author> authors = authorRepository.findAll();
        return authorMapper.toDto(authors);
    }

    public AuthorDto getAuthorById(Long id) {
        if (Objects.isNull(id)) {
            throw new BadRequestException(Error.BAD_REQUEST_ERROR_CODE, Error.BAD_REQUEST_ERROR_MESSAGE);
        }
        Author foundAuthor = authorRepository.findById(id).orElseThrow(()
                -> new NotFoundException(Error.NOT_FOUND_ERROR_CODE,
                Error.AUTHOR_NOT_FOUND_ERROR_MESSAGE));
        return authorMapper.toDto(foundAuthor);
    }

    @Transactional
    public void addAuthor(AuthorDto authorDto) {
        if (Objects.isNull(authorDto) || Objects.isNull(authorDto.getName())) {
            throw new BadRequestException(Error.BAD_REQUEST_ERROR_CODE, Error.BAD_REQUEST_ERROR_MESSAGE);
        }
        Author author = authorMapper.toEntity(authorDto);
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
        if (Objects.isNull(id) || Objects.isNull(authorDto)) {
            throw new BadRequestException(Error.BAD_REQUEST_ERROR_CODE, Error.BAD_REQUEST_ERROR_MESSAGE);
        }
        Author author = authorRepository.findById(id).orElseThrow(
                () -> new NotFoundException(Error.NOT_FOUND_ERROR_CODE,
                        Error.AUTHOR_NOT_FOUND_ERROR_MESSAGE));

        List<Book> books = bookRepository.findAllByIdIn(authorDto.getBookIdList());
        author = mapper.toAuthorEntity(books, authorDto, author);
        authorRepository.save(author);
    }
}
