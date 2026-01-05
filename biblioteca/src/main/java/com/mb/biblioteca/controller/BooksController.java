package com.mb.biblioteca.controller;

import com.mb.biblioteca.dto.request.BooksRequest;
import com.mb.biblioteca.dto.response.BooksResponse;
import com.mb.biblioteca.service.BooksService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livros")
public class BooksController {
    private final BooksService booksService;

    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<BooksResponse> register(@RequestBody BooksRequest booksRequest){
        BooksResponse books = booksService.cadastrar(booksRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(books);
    }


}
