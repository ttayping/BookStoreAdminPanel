package com.example.lesson4_2.dao.entity;

import com.example.lesson4_2.model.enums.Currency;
import com.example.lesson4_2.model.enums.Language;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "book")
@Getter
@Setter
public class Book extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "language", nullable = false)
    private Language language;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "price", nullable = false)
    private Currency currency;

    @Column(name = "publicationDate", nullable = false)
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