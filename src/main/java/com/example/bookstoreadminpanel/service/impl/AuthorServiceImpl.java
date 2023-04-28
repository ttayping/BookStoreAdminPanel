package com.example.bookstoreadminpanel.service.impl;

import com.example.bookstoreadminpanel.dao.entity.Author;
import com.example.bookstoreadminpanel.dao.repository.AuthorRepository;
import com.example.bookstoreadminpanel.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> getAuthorById(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public Author addAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public void deleteAuthorById(Long id) {
        authorRepository.deleteById(id);
    }

    @Override
    public Author updateAuthor(Long id, Author author) {
        Optional<Author> resultAuthor = authorRepository.findById(id);
        if(resultAuthor.isPresent()){
            resultAuthor.get().setName(author.getName());
            resultAuthor.get().setBooks(author.getBooks());
            resultAuthor.get().setUpdateDate(author.getUpdateDate());
            resultAuthor.get().setCreateDate(author.getCreateDate());
        }
        return authorRepository.save(resultAuthor.get());
    }
}
