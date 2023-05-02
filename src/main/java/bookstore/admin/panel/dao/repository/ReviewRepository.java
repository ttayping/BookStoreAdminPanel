package bookstore.admin.panel.dao.repository;

import bookstore.admin.panel.dao.entity.Book;
import bookstore.admin.panel.dao.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findAllByBook(Book book);
}
