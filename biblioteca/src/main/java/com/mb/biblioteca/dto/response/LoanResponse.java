package com.mb.biblioteca.dto.response;

import com.mb.biblioteca.model.enuns.LoanStatus;
import com.mb.biblioteca.model.User;

import java.time.LocalDate;

public record LoanResponse(
        Long id,
        String tituloLivro,
        String usuario,
        LocalDate dataEmprestimo,
        LocalDate dataDevolucao,
        LoanStatus status
) {
}
