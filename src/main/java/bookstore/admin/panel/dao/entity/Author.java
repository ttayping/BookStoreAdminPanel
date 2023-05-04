package bookstore.admin.panel.dao.entity;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "author")
@Getter
@Setter
public class Author extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surName")
    private String surName;

    @Column(name = "mail")
    private String mail;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @ManyToMany(mappedBy = "authors")
    private List<Book> books;

    public List<Long> getBooksId() {
        List<Long> longs = new ArrayList<>();
        for (Book book : books) {
            longs.add(book.getId());
        }return longs;
    }
}