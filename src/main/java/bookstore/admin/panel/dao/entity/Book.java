package bookstore.admin.panel.dao.entity;

import bookstore.admin.panel.model.enums.Language;
import javax.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;
import java.util.List;

@Entity
@Table(name = "book")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "language")
    private Language language;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "currency")
    private Currency currency;

    @Column(name = "publicationDate")
    private LocalDate publicationDate;

    @Column(name = "description")
    private String description;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "book")
    private List<Review> reviewList;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "book_publisher",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "publisher_id")}
    )
    private List<Publisher> publishers;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "book_author",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "author_id")}
    )
    private List<Author> authors;

}

