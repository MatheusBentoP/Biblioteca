package com.mb.biblioteca.dto.response;

import java.util.List;

public record UserResponse(
        Long id, String nome,
        String matricula,
        List<LoanResponse> emprestimos) {
}
