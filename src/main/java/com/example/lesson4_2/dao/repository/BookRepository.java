package com.example.lesson4_2.dao.repository;

import com.example.lesson4_2.dao.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
