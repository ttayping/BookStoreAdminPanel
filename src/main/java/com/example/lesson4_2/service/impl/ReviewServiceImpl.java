package com.example.lesson4_2.service.impl;

import com.example.lesson4_2.dao.repository.ReviewRepository;
import com.example.lesson4_2.service.ReviewService;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }
}
