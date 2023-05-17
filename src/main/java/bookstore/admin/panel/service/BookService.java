package bookstore.admin.panel.service;

import bookstore.admin.panel.dao.entity.Author;
import bookstore.admin.panel.dao.entity.Publisher;
import bookstore.admin.panel.dao.repository.AuthorRepository;
import bookstore.admin.panel.dao.repository.PublisherRepository;
import bookstore.admin.panel.exception.BadRequestException;
import bookstore.admin.panel.exception.Error;
import bookstore.admin.panel.exception.NotFoundException;
import bookstore.admin.panel.filter.BookFilter;
import bookstore.admin.panel.filter.BookSpecification;
import bookstore.admin.panel.mapper.BookMapper;
import bookstore.admin.panel.mapper.Mapper;
import bookstore.admin.panel.model.dto.BookDto;
import bookstore.admin.panel.dao.entity.Book;
import bookstore.admin.panel.dao.repository.BookRepository;

import bookstore.admin.panel.model.enums.Language;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;
    private static final Mapper mapper = Mapper.MAPPER;
    private static final BookMapper bookMapper = BookMapper.BOOK_MAPPER;


    public void addBook(BookDto bookDto) {
        Book book = bookMapper.toEntity(bookDto);
        if (Objects.isNull(book.getName()) || Objects.isNull(book.getCurrency())
                || Objects.isNull(book.getPrice()) || Objects.isNull(book.getLanguage())
        ) {
            throw new BadRequestException(Error.BAD_REQUEST_ERROR_CODE, Error.BAD_REQUEST_ERROR_MESSAGE);
        }
        List<Author> authors = authorRepository.findAllByIdIn(bookDto.getAuthorIdList());
        if (Objects.nonNull(authors)) {
            book.setAuthors(authors);
        }
        List<Publisher> publishers = publisherRepository.findAllByIdIn(bookDto.getPublisherIdList());
        if (Objects.nonNull(publishers)) {
            book.setPublishers(publishers);
        }
        bookRepository.save(book);
    }

    public List<BookDto> getAllBooks() {
        return bookMapper.toDto(bookRepository.findAll());
    }

    public BookDto getBookById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(
                () -> new BadRequestException(Error.NOT_FOUND_ERROR_CODE,
                        Error.BOOK_NOT_FOUND_ERROR_MESSAGE));
        return bookMapper.toDto(book);
    }

    public void updateBook(Long id, BookDto bookDto) {
        Book book = bookRepository.findById(id).orElseThrow(
                () -> new NotFoundException(Error.NOT_FOUND_ERROR_CODE,
                        Error.BOOK_NOT_FOUND_ERROR_MESSAGE));
        List<Author> authors = authorRepository.findAllByIdIn(bookDto.getAuthorIdList());
        List<Publisher> publishers = publisherRepository.findAllByIdIn(bookDto.getPublisherIdList());
        book = mapper.toBookEntity(authors, publishers, bookDto, book);

        bookRepository.save(book);
    }

    public void deleteBookById(Long id) {
        bookRepository.findById(id).orElseThrow(
                () -> new NotFoundException(Error.NOT_FOUND_ERROR_CODE,
                        Error.BOOK_NOT_FOUND_ERROR_MESSAGE));
        bookRepository.deleteById(id);
    }

    public List<List<BookDto>> getBooksByAuthorName(String authorName) {
        if (Objects.isNull(authorName)) {
            throw new BadRequestException(Error.BAD_REQUEST_ERROR_CODE, Error.BAD_REQUEST_ERROR_MESSAGE);
        }
        List<List<BookDto>> books = new ArrayList<>();
        List<Author> authors = authorRepository.findAuthorByName(authorName);
        if (authors.isEmpty()) {
            throw new NotFoundException(Error.NOT_FOUND_ERROR_CODE, Error.AUTHOR_NOT_FOUND_ERROR_MESSAGE);
        }
        for (Author author : authors) {
            books.add(bookMapper.toDto(author.getBooks()));
        }
        return books;
    }

    public List<BookDto> getBooksByLanguage(Language language) {
        if (Objects.isNull(language)) {
            throw new BadRequestException(Error.BAD_REQUEST_ERROR_CODE, Error.BAD_REQUEST_ERROR_MESSAGE);
        }
        List<Book> books = bookRepository.getBooksByLanguage(language);
        if (books.isEmpty()) {
            throw new NotFoundException(Error.NOT_FOUND_ERROR_CODE, Error.BOOK_NOT_FOUND_ERROR_MESSAGE);
        }
        return bookMapper.toDto(books);
    }

    public List<List<BookDto>> getBooksByPublisherName(String publisherName) {
        List<List<BookDto>> books = new ArrayList<>();
        if (Objects.isNull(publisherName)) {
            throw new BadRequestException(Error.BAD_REQUEST_ERROR_CODE, Error.BAD_REQUEST_ERROR_MESSAGE);
        }
        List<Publisher> publishers = publisherRepository.findPublisherByName(publisherName);
        if (publishers.isEmpty()) {
            throw new NotFoundException(Error.NOT_FOUND_ERROR_CODE, Error.PUBLISHER_NOT_FOUND_ERROR_MESSAGE);
        }
        for (Publisher publisher : publishers) {
            books.add(bookMapper.toDto(publisher.getBooks()));
        }
        return books;
    }

    public Integer getStockByBookId(Long id) {
        if (Objects.isNull(id)) {
            throw new BadRequestException(Error.BAD_REQUEST_ERROR_CODE, Error.BAD_REQUEST_ERROR_MESSAGE);
        }
        Book book = bookRepository.findById(id).orElseThrow(()
                -> new NotFoundException(Error.NOT_FOUND_ERROR_CODE,
                Error.BOOK_NOT_FOUND_ERROR_MESSAGE));
        return book.getStock();
    }

    public void addStockByBookId(Long id, Integer newStock) {
        if (Objects.isNull(id) || Objects.isNull(newStock)) {
            throw new BadRequestException(Error.BAD_REQUEST_ERROR_CODE, Error.BAD_REQUEST_ERROR_MESSAGE);
        }
        Book book = bookRepository.findById(id).orElseThrow(()
                -> new NotFoundException(Error.NOT_FOUND_ERROR_CODE,
                Error.BOOK_NOT_FOUND_ERROR_MESSAGE));
        book.setStock(book.getStock() + newStock);
        bookRepository.save(book);
    }

    public List<BookDto> getBooks(BookFilter filter) {
        List<Book> books = bookRepository.findAll(new BookSpecification(filter));
        List<BookDto> bookDtos = bookMapper.toDto(books);
//  it will NOT work when filter return two or more books!
        List<Long> idList = new ArrayList<>();
        idList.add(books.iterator().next().getAuthors().iterator().next().getId());
        bookDtos.iterator().next().setAuthorIdList(idList);

        return bookDtos;
    }


}