package com.mb.biblioteca.dto.request;

import com.mb.biblioteca.model.enuns.Genres;

public record BooksRequest(
        String title,
        String author,
        Integer pages,
        String publisher,
        Genres genres
) {
}
