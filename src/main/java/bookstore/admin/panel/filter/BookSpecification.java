package bookstore.admin.panel.filter;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import bookstore.admin.panel.dao.entity.Book;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ObjectUtils;
public class BookSpecification implements Specification<Book> {

    private final BookFilter filter;

    public BookSpecification(BookFilter filter) {
        this.filter = filter;
    }

     @Override
    public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

        List<Predicate> predicates = new ArrayList<>();

        if (!ObjectUtils.isEmpty(filter.getName())) {
            predicates.add(root.get("name").in(filter.getName()));
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
    }
}

