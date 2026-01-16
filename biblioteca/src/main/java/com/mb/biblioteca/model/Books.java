package com.mb.biblioteca.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

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


    @Enumerated(EnumType.STRING)
    @Column(name = "genre")
    public Genres genres;

    @OneToMany(mappedBy = "livros", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Loan> emprestimo = new ArrayList<>();

    public Books() {
    }

    public Books(Long id, String title, String author, Integer pages, String publisher, Genres genres, List<Loan> emprestimos) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.publisher = publisher;
        this.genres = genres;
        this.emprestimo = emprestimos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Genres getGenres() {
        return genres;
    }

    public void setGenres(Genres genres) {
        this.genres = genres;
    }

    public List<Loan> getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(List<Loan> emprestimo) {
        this.emprestimo = emprestimo;
    }
}
