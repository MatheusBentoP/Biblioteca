package com.mb.biblioteca.mapper;

import com.mb.biblioteca.dto.response.LoanResponse;
import com.mb.biblioteca.model.Loan;

public class LoanMapper {

    public static LoanResponse toDto(Loan emprestimo){
        return new LoanResponse(
                emprestimo.getId(),
                emprestimo.getLivros().getTitle(),
                emprestimo.getAlunos().getNome(),
                emprestimo.getDataEmprestimo(),
                emprestimo.getDataDevolucao(),
                emprestimo.getStatus()
        );
    }
}
