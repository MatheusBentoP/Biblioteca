package com.mb.biblioteca.dto.request;

import com.mb.biblioteca.model.Genres;

public record BooksRequest(
        String title,
        String author,
        Integer pages,
        String publisher,
        Genres genres
) {
}
