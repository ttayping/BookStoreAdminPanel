package com.example.bookstoreadminpanel.dao.repository;

import com.example.bookstoreadminpanel.dao.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}
