package com.example.bookstoreadminpanel.dao.repository;

import com.example.bookstoreadminpanel.dao.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
