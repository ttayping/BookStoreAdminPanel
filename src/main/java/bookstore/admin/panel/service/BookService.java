package bookstore.admin.panel.service;

import bookstore.admin.panel.dao.entity.Author;
import bookstore.admin.panel.dao.repository.AuthorRepository;
import bookstore.admin.panel.mapper.BookMapper;
import bookstore.admin.panel.mapper.BookMapper2;
import bookstore.admin.panel.model.dto.BookDto;
import bookstore.admin.panel.dao.entity.Book;
import bookstore.admin.panel.dao.repository.BookRepository;
import bookstore.admin.panel.model.dto.BookRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private static final BookMapper2 mapper = BookMapper2.MAPPER_2;


    public void addBook(BookRequestDto bookRequestDto) {
        Book book = BookMapper.toBook(bookRequestDto);
        List<Author> authors = authorRepository.findAllByIdIn(bookRequestDto.getAuthorIdList());
        if (!authors.isEmpty()) {
            book.setAuthors(authors);
        }
        bookRepository.save(book);
    }


    public List<BookDto> getAllBooks() {
        return BookMapper.toBookDtoList(bookRepository.findAll());
    }


    public BookDto getBookById(Long id) {
        return  mapper.toBookDto(bookRepository.findById(id).get());
    }
//
//
//    public Book updateBook(Long id, Book book) {
//        Optional<Book> resultBook = bookRepository.findById(id);
//        if (resultBook.isPresent()) {
//            resultBook.get().setName(book.getName());
//            resultBook.get().setPrice(book.getPrice());
//            resultBook.get().setCurrency(book.getCurrency());
//            resultBook.get().setLanguage(book.getLanguage());
//            resultBook.get().setDescription(book.getDescription());
//            resultBook.get().setPublicationDate(book.getPublicationDate());
//            resultBook.get().setReviewList(book.getReviewList());
//            resultBook.get().setPublishers(book.getPublishers());
//            resultBook.get().setAuthors(book.getAuthors());
//            return bookRepository.save(resultBook.get());
//        }
//        return null;
//    }
//
//
    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }
//
//
//    public BookDto getBookByName(String name) {
//        List<Book> books = bookRepository.findAll();
//        for (Book book : books) {
//            if (Objects.equals(book.getName(), name)) return book;
//        }
//        return null;
//    }
//
//
//    public BookDto getBookByAuthor(String authorName) {
//        List<Book> books = bookRepository.findAll();
//        for (Book book : books) {
//            if (Objects.equals(book.getAuthors(), authorName)) return book; // not finished
//        }
//        return null;
//    }
//
//
//    public List<BookDto> getBooksByLanguage(String language) {
//        List<Book> books = bookRepository.findAll();
//        List<Book> foundedBooks = new ArrayList<>();
//        for (Book book : books) {
//            if (Objects.equals(book.getLanguage(), language)) ;
//            foundedBooks.add(book);
//            return foundedBooks;
//        }
//        return null;
//    }
}
