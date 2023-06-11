package bookstore.admin.panel.dao.repository;

import bookstore.admin.panel.dao.entity.Book;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByIdIn(List<Long> id);

    List<Book> findAll(Specification<Book> bookSpecification);
}
