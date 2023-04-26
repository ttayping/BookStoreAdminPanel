package com.example.lesson4_2.service.impl;

import com.example.lesson4_2.dao.repository.AuthorRepository;
import com.example.lesson4_2.service.AuthorService;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
}
