package com.example.lesson4_2.dao.repository;

import com.example.lesson4_2.dao.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}
