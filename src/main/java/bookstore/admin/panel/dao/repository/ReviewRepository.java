package bookstore.admin.panel.dao.repository;

import bookstore.admin.panel.dao.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
