package com.example.lesson4_2.dao.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "author")
@Getter
@Setter
public class Author extends BaseEntity{

    @Column(name = "name", nullable = false)
    private String name;
}
