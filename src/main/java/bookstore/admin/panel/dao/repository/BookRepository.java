package bookstore.admin.panel.dao.repository;

import bookstore.admin.panel.dao.entity.Book;
import bookstore.admin.panel.filter.BookSpecification;
import bookstore.admin.panel.model.enums.Language;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> getBooksByName(String name);

    List<Book> getBooksByLanguage(Language language);

    List<Book> findAllByIdIn(List<Long> id);
}
