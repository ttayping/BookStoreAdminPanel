package bookstore.admin.panel.dao.repository;

import bookstore.admin.panel.dao.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
    List<Publisher> findPublisherByName(String publisherName);
}

