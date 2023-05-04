package bookstore.admin.panel.service;

import bookstore.admin.panel.dao.entity.Author;
import bookstore.admin.panel.dao.entity.Publisher;
import bookstore.admin.panel.dao.repository.AuthorRepository;
import bookstore.admin.panel.dao.repository.PublisherRepository;
import bookstore.admin.panel.exception.BadRequestException;
import bookstore.admin.panel.exception.Error;
import bookstore.admin.panel.exception.NotFoundException;
import bookstore.admin.panel.mapper.UniversalMapper;
import bookstore.admin.panel.model.dto.BookDto;
import bookstore.admin.panel.dao.entity.Book;
import bookstore.admin.panel.dao.repository.BookRepository;

import bookstore.admin.panel.model.dto.BookRequestDto;
import bookstore.admin.panel.model.enums.Language;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;
    private static final UniversalMapper mapper = UniversalMapper.MAPPER;

    public void addBook(BookDto bookDto) {
        Book book = mapper.toBookEntity(bookDto);
        List<Author> authors = authorRepository.findAllByIdIn(bookDto.getAuthorIdList());
        if (!authors.isEmpty()) {
            book.setAuthors(authors);
        }
        List<Publisher> publishers = publisherRepository.findAllByIdIn(bookDto.getPublisherIdList());
        if (!publishers.isEmpty()){
            book.setPublishers(publishers);
        }
        bookRepository.save(book);
    }

    public List<BookRequestDto> getAllBooks() {
        return mapper.toBookRequestDtoList(bookRepository.findAll());
    }

    public BookRequestDto getBookById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(
                () -> new BadRequestException(Error.BOOK_NOT_FOUND_ERROR_CODE,
                        Error.BOOK_NOT_FOUND_ERROR_MESSAGE));
        return mapper.toBookRequestDto(book);
    }

    public void updateBook(Long id, BookDto bookDto) {
        Book book = bookRepository.findById(id).orElseThrow(
                () -> new NotFoundException(Error.BOOK_NOT_FOUND_ERROR_CODE,
                        Error.BOOK_NOT_FOUND_ERROR_MESSAGE));
        book.setName(bookDto.getBookName());
        book.setStock(bookDto.getStock());
        book.setLanguage(bookDto.getLanguage());
        book.setPrice(bookDto.getPrice());
        book.setCurrency(bookDto.getCurrency());
        book.setPublicationDate(bookDto.getPublicationDate());
        book.setDescription(bookDto.getDescription());
        book.setAuthors(authorRepository.findAllByIdIn(bookDto.getAuthorIdList()));
        book.setPublishers(publisherRepository.findAllByIdIn(bookDto.getPublisherIdList()));
        bookRepository.save(book);
    }

    public void deleteBookById(Long id) {
        bookRepository.findById(id).orElseThrow(
                () -> new NotFoundException(Error.BOOK_NOT_FOUND_ERROR_CODE,
                        Error.BOOK_NOT_FOUND_ERROR_MESSAGE));
        bookRepository.deleteById(id);
    }

    public List<BookRequestDto> getBookByName(String name) {
        return mapper.toBookRequestDtoList(bookRepository.getBooksByName(name));
    }

    public List<List<BookRequestDto>> getBooksByAuthorName(String authorName) {
        List<List<BookRequestDto>> books = new ArrayList<>();
        for (Author author : authorRepository.findAuthorByName(authorName)) {
            books.add(mapper.toBookRequestDtoList(author.getBooks()));
        }
        return books;
    }

    public List<BookRequestDto> getBooksByLanguage(Language language) {
        return mapper.toBookRequestDtoList(bookRepository.getBooksByLanguage(language));
    }

    public List<List<BookRequestDto>> getBooksByPublisherName(String publisherName) {
        List<List<BookRequestDto>> books = new ArrayList<>();
        for (Publisher publisher : publisherRepository.findPublisherByName(publisherName)) {
            books.add(mapper.toBookRequestDtoList(publisher.getBooks()));
        }
        return books;
    }

    public Integer getStockByBookId(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(()
                -> new NotFoundException(Error.BOOK_NOT_FOUND_ERROR_CODE,
                Error.BOOK_NOT_FOUND_ERROR_MESSAGE));
        return book.getStock();
    }

    public void addStockByBookId(Long id, Integer newStock) {
        Book book = bookRepository.findById(id).orElseThrow(()
                -> new NotFoundException(Error.BOOK_NOT_FOUND_ERROR_CODE,
                Error.BOOK_NOT_FOUND_ERROR_MESSAGE));
        book.setStock(book.getStock() + newStock);
        bookRepository.save(book);
    }
}
