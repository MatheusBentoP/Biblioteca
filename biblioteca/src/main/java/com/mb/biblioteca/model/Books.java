package com.mb.biblioteca.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "livros")
@Data
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private Integer pages;
    private String publisher;
    public Genres genres;
}
