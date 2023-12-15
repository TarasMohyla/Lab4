package com.lab4.Library.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;


    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;


    @Column(name = "price")
    private Integer price;

    @Column
    private Boolean isActive = Boolean.TRUE;
}
