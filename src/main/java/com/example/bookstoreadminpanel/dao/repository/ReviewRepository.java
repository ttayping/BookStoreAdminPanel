package com.example.bookstoreadminpanel.dao.repository;

import com.example.bookstoreadminpanel.dao.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
