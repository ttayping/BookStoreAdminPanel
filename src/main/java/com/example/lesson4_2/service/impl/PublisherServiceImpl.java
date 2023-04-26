package com.example.lesson4_2.service.impl;

import com.example.lesson4_2.dao.repository.PublisherRepository;
import com.example.lesson4_2.service.PublisherService;
import org.springframework.stereotype.Service;

@Service
public class PublisherServiceImpl implements PublisherService {
    private final PublisherRepository publisherRepository;

    public PublisherServiceImpl(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }
}
