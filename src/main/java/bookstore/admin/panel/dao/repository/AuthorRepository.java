package bookstore.admin.panel.dao.repository;

import bookstore.admin.panel.dao.entity.Author;
import bookstore.admin.panel.dao.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findAllByIdIn(List<Long> idList);

    List<Author> findAuthorByName(String name);
}
