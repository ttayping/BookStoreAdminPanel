package com.example.lesson4_2.dao.repository;

import com.example.lesson4_2.dao.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository <Author,Long> {
}
