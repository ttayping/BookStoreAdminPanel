package com.example.bookstoreadminpanel.dao.entity;

import com.example.bookstoreadminpanel.model.Language;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;
import java.util.List;

@Entity
@Table(name = "book")
@Getter
@Setter
public class Book extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "language", nullable = true)
    private Language language;

    @Column(name = "price", nullable = true)
    private BigDecimal price;

    @Column(name = "currency", nullable = true)
    private Currency currency;

    @Column(name = "publicationDate", nullable = true)
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

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "book_author",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "author_id")}
    )
    private List<Author> authors;
}

