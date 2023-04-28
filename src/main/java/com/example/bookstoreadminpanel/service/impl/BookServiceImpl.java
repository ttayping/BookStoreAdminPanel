package com.example.bookstoreadminpanel.service.impl;

import com.example.bookstoreadminpanel.dao.entity.Book;
import com.example.bookstoreadminpanel.dao.repository.BookRepository;
import com.example.bookstoreadminpanel.service.BookService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long id) {
        Optional<Book> foundedBook = bookRepository.findById(id);
        return foundedBook.orElse(null);
    }

    @Override
    public Book updateBook(Long id, Book book) {
        Optional<Book> resultBook = bookRepository.findById(id);
        if (resultBook.isPresent()) {
            resultBook.get().setName(book.getName());
            resultBook.get().setPrice(book.getPrice());
            resultBook.get().setCurrency(book.getCurrency());
            resultBook.get().setLanguage(book.getLanguage());
            resultBook.get().setDescription(book.getDescription());
            resultBook.get().setPublicationDate(book.getPublicationDate());
            resultBook.get().setReviewList(book.getReviewList());
            resultBook.get().setPublishers(book.getPublishers());
            resultBook.get().setAuthors(book.getAuthors());
            return bookRepository.save(resultBook.get());
        }
        return null;
    }

    @Override
    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Book getBookByName(String name) {
        List<Book> books = bookRepository.findAll();
        for (Book book : books) {
            if (Objects.equals(book.getName(), name)) return book;
        }
        return null;}

    @Override
    public Book getBookByAuthor(String authorName) {
        List<Book> books = bookRepository.findAll();
//        for (Book book : books) {
//            if (Objects.equals(book.getAuthors(), authorName)) return book; // not finished
//        }
        return null;
    }

    @Override
    public List<Book> getBooksByLanguage(String language) {
        List<Book> books = bookRepository.findAll();
        List<Book> foundedBooks = new ArrayList<>();
        for (Book book : books) {
            if (Objects.equals(book.getLanguage(), language));
            foundedBooks.add(book);
        return foundedBooks;}
        return null;
    }
}
