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

    public List<BookDto> getAllBooks() {
        return mapper.toBookDtoList(bookRepository.findAll());
    }

    public BookDto getBookById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(
                () -> new BadRequestException(Error.BOOK_NOT_FOUND_ERROR_CODE,
                        Error.BOOK_NOT_FOUND_ERROR_MESSAGE));
        return mapper.toBookDto(book);
    }

    public void updateBook(Long id, BookDto bookDto) {
        Book book = bookRepository.findById(id).orElseThrow(
                () -> new NotFoundException(Error.BOOK_NOT_FOUND_ERROR_CODE,
                        Error.BOOK_NOT_FOUND_ERROR_MESSAGE));
        book.setName(bookDto.getBookName());
        book.setLanguage(book.getLanguage());
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

    public List<BookDto> getBookByName(String name) {
        return mapper.toBookDtoList(bookRepository.getBooksByName(name));
    }

    public List<List<BookDto>> getBooksByAuthorName(String authorName) {
        List<List<BookDto>> books = new ArrayList<>();
        for (Author author : authorRepository.findAuthorByName(authorName)) {
            books.add(mapper.toBookDtoList(author.getBooks()));
        }
        return books;
    }

    public List<BookDto> getBooksByLanguage(Language language) {
        return mapper.toBookDtoList(bookRepository.getBooksByLanguage(language));
    }

    public List<List<BookDto>> getBooksByPublisherName(String publisherName) {
        List<List<BookDto>> books = new ArrayList<>();
        for (Publisher publisher : publisherRepository.findPublisherByName(publisherName)) {
            books.add(mapper.toBookDtoList(publisher.getBooks()));
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
