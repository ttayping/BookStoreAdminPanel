package com.example.bookstoreadminpanel.dao.repository;

import com.example.bookstoreadminpanel.dao.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {
}
