package com.example.bookstoreadminpanel.dao.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "publisher")
@Getter
@Setter
public class Publisher extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany(mappedBy = "publishers")
    private List<Book> books;

}
