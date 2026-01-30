package com.mb.biblioteca.repository;

import com.mb.biblioteca.model.Books;
import com.mb.biblioteca.model.Loan;
import com.mb.biblioteca.model.enuns.LoanStatus;
import com.mb.biblioteca.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILoanRepository extends JpaRepository<Loan, Long> {

    boolean existsByLivrosAndStatus(Books books, LoanStatus status);

    long countByAlunosAndStatus(User Alunos, LoanStatus status);

    long countByStatus(LoanStatus status);
}
