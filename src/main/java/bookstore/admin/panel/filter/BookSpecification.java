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

    private final Long bookId;

    public BookSpecification(BookFilter filter, Long bookId) {
        this.filter = filter;
        this.bookId = bookId;
    }

     @Override
    public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

        List<Predicate> predicates = new ArrayList<>();

        predicates.add(criteriaBuilder.isNotNull(root.get("iban")));

        if (bookId != null) {
            predicates.add(criteriaBuilder.equal(root.get("bookId"), bookId));
        }

        if (!ObjectUtils.isEmpty(filter.getName())) {
            predicates.add(root.get("name").in(filter.getName()));
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
    }
}
/*
    public List<AccountView> getAccountsList(String customerId, AccountFilter filter)
    {    log.info("ActionLog.AccountService.getAccounts for {} start", customerId);
        List<AccountEntity> accounts = accountRepository.findAll(new AccountSpecification(filter, customerId));

        @GetMappingpublic List<AccountView> getAccounts(@RequestHeader(value = "customer-id") String customerId,
                AccountFilter filter) {    log.debug("getAccounts for {} start", customerId);
            List<AccountView> responseDto = accountService.getAccountsList(customerId, filter);    log.debug("getAccounts for {} end", customerId);
            return responseDto;}

 */
