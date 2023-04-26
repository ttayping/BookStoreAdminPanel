package com.example.lesson4_2.dao.repository;

import com.example.lesson4_2.dao.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Long> {
}
