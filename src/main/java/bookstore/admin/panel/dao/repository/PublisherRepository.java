package bookstore.admin.panel.dao.repository;

import bookstore.admin.panel.dao.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}
