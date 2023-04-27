package com.example.bookstoreadminpanel.service.impl;

import com.example.bookstoreadminpanel.dao.repository.PublisherRepository;
import com.example.bookstoreadminpanel.service.PublisherService;
import org.springframework.stereotype.Service;

@Service
public class PublisherServiceImpl implements PublisherService {
    private final PublisherRepository publisherRepository;

    public PublisherServiceImpl(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }
}
