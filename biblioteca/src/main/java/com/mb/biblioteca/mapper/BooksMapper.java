package com.mb.biblioteca.mapper;

import com.mb.biblioteca.dto.request.BooksRequest;
import com.mb.biblioteca.dto.response.BooksResponse;
import com.mb.biblioteca.model.Books;


public class BooksMapper {
    public static Books toEntity(BooksRequest request){
        Books book = new Books();
        book.setTitle(request.title());
        book.setAuthor(request.author());
        book.setPages(request.pages());
        book.setGenres(request.genres());
        book.setPublisher(request.publisher());

        return book;
    }

    public static BooksResponse toDto(Books books){
        return new BooksResponse(
                        books.getId(),
                        books.getTitle(),
                        books.getAuthor(),
                        books.getPages(),
                books.getPublisher(),
                books.getGenres());
    }
}
