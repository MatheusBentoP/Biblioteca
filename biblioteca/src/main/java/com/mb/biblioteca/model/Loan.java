package com.mb.biblioteca.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "emprestimo")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataEmprestimo;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataDevolucao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "livros_id", nullable = false)
    private Books livros;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuarios_id", nullable = false)
    private User alunos;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "emprestimo")
    private LoanStatus status;


    public Loan() {
    }

    public Loan(Long id, LocalDate dataEmprestimo, LocalDate dataDevolucao, Books livros, User alunos, LoanStatus status) {
        this.id = id;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.livros = livros;
        this.alunos = alunos;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Books getLivros() {
        return livros;
    }

    public void setLivros(Books livros) {
        this.livros = livros;
    }

    public User getAlunos() {
        return alunos;
    }

    public void setAlunos(User alunos) {
        this.alunos = alunos;
    }

    public LoanStatus getStatus() {
        return status;
    }

    public void setStatus(LoanStatus status) {
        this.status = status;
    }
}
