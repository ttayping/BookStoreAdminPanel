package bookstore.admin.panel.service;

import bookstore.admin.panel.dao.entity.Author;
import bookstore.admin.panel.dao.repository.AuthorRepository;
import bookstore.admin.panel.mapper.BookMapper;
import bookstore.admin.panel.mapper.BookMapper2;
import bookstore.admin.panel.model.dto.BookDto;
import bookstore.admin.panel.dao.entity.Book;
import bookstore.admin.panel.dao.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private static final BookMapper2 mapper = BookMapper2.MAPPER_2;


    public void addBook(BookDto bookDto) {
        Book book = BookMapper.toBook(bookDto);
        List<Author> authors = authorRepository.findAllByIdIn(bookDto.getAuthorIdList());
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

    public void updateBook(Long id, BookDto bookDto) {
        Optional<Book> resultBook = bookRepository.findById(id);
        Book book = BookMapper.toBook(bookDto);
        if (resultBook.isPresent()) {
            resultBook.get().setName(book.getName());
            resultBook.get().setLanguage(book.getLanguage());
            resultBook.get().setAuthors(authorRepository.findAllByIdIn(bookDto.getAuthorIdList()));
            bookRepository.save(resultBook.get());
        }
    }


    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }


    public BookDto getBookByName(String name) {

//        List<Book> books = bookRepository.findAll();
//        for (Book book : books) {
//            if (Objects.equals(book.getName(), name)) return book;
//        }
        return null;
    }


    public BookDto getBookByAuthor(String authorName) {
//        List<Book> books = bookRepository.findAll();
//        for (Book book : books) {
//            if (Objects.equals(book.getAuthors(), authorName)) return book; // not finished
//        }
        return null;
    }


    public List<BookDto> getBooksByLanguage(String language) {
//        List<Book> books = bookRepository.findAll();
//        List<Book> foundedBooks = new ArrayList<>();
//        for (Book book : books) {
//            if (Objects.equals(book.getLanguage(), language)) ;
//            foundedBooks.add(book);
//            return foundedBooks;
//        }
        return null;
    }
}
