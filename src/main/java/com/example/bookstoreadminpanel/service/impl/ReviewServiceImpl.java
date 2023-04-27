package com.example.bookstoreadminpanel.service.impl;

import com.example.bookstoreadminpanel.dao.repository.ReviewRepository;
import com.example.bookstoreadminpanel.service.ReviewService;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }
}
