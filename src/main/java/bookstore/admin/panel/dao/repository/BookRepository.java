package bookstore.admin.panel.dao.repository;

import bookstore.admin.panel.dao.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
    Book getBookByName(String name);
}
