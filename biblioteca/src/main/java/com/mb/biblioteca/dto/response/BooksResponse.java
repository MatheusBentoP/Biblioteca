package com.mb.biblioteca.dto.response;

import com.mb.biblioteca.model.enuns.Genres;

public record BooksResponse(
         Long id,
         String title,
         String author,
         Integer pages,
         String publisher,
         Genres genres
) {
}
