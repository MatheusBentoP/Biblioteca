package com.mb.biblioteca.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "emprestimo")
public class Loans {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataDeEmprestimo;
    private LocalDateTime dataDeDevolucao;

    @ManyToOne
    private Books livros;

    @ManyToOne
    private User alunos;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "emprestimo")
    private LoanStatus status;
}
