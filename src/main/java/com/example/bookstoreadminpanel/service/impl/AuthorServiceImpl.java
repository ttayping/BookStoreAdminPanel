package com.example.bookstoreadminpanel.service.impl;

import com.example.bookstoreadminpanel.dao.repository.AuthorRepository;
import com.example.bookstoreadminpanel.service.AuthorService;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
}
