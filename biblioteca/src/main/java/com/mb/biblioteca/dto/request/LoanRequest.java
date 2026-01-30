package com.mb.biblioteca.dto.request;

public record LoanRequest(
        Long livroId,
        String tituloDoLivro) {
}
