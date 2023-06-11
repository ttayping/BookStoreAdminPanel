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
import bookstore.admin.panel.mapper.BookRequestMapper;
import bookstore.admin.panel.mapper.BookResponseMapper;
import bookstore.admin.panel.mapper.Mapper;
import bookstore.admin.panel.model.dto.BookRequestDto;
import bookstore.admin.panel.dao.entity.Book;
import bookstore.admin.panel.dao.repository.BookRepository;

import bookstore.admin.panel.model.dto.BookResponseDto;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;
    private final Executor asyncExecutor;
    private static final Mapper mapper = Mapper.MAPPER;
    private static final BookRequestMapper bookRequestMapper = BookRequestMapper.BOOK_REQUEST_MAPPER;
    private static final BookResponseMapper bookResponseMapper = BookResponseMapper.BOOK_RESPONSE_MAPPER;


    public void addBook(BookRequestDto bookDto) {
        Book book = bookRequestMapper.toEntity(bookDto);
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

    public List<BookResponseDto> getAllBooks() {
        return bookResponseMapper.toDto(bookRepository.findAll());
    }

    public BookResponseDto getBookById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(
                () -> new BadRequestException(Error.NOT_FOUND_ERROR_CODE,
                        Error.BOOK_NOT_FOUND_ERROR_MESSAGE));
        return bookResponseMapper.toDto(book);
    }

    @SneakyThrows
    public void updateBook(Long id, BookRequestDto bookDto) {
        var bookCompletableFuture = CompletableFuture.supplyAsync(() ->
                bookRepository.findById(id).orElseThrow(() ->
                        new NotFoundException(Error.NOT_FOUND_ERROR_CODE, Error.BOOK_NOT_FOUND_ERROR_MESSAGE)), asyncExecutor);
        var authorsCompletableFuture = CompletableFuture.supplyAsync(() ->
                authorRepository.findAllByIdIn(bookDto.getAuthorIdList()));
        var publishersCompletableFuture = CompletableFuture.supplyAsync(() ->
                publisherRepository.findAllByIdIn(bookDto.getPublisherIdList()));

        CompletableFuture.allOf(bookCompletableFuture, authorsCompletableFuture, publishersCompletableFuture).join();
        Book book=bookCompletableFuture.get();
        List<Author> authors=authorsCompletableFuture.get();
        List<Publisher> publishers = publishersCompletableFuture.get();

        book = mapper.toBookEntity(authors, publishers, bookDto, book);

        bookRepository.save(book);
    }

    public void deleteBookById(Long id) {
        bookRepository.findById(id).orElseThrow(
                () -> new NotFoundException(Error.NOT_FOUND_ERROR_CODE,
                        Error.BOOK_NOT_FOUND_ERROR_MESSAGE));
        bookRepository.deleteById(id);
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

    public List<BookResponseDto> getBooks(BookFilter filter) {
        List<Book> books = bookRepository.findAll(new BookSpecification(filter));
        return bookResponseMapper.toDto(books);
    }


}