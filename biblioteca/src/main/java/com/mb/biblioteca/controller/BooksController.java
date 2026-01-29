package com.mb.biblioteca.controller;

import com.mb.biblioteca.dto.request.BooksRequest;
import com.mb.biblioteca.dto.response.BooksResponse;
import com.mb.biblioteca.service.BooksService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class BooksController {

    private final BooksService booksService;

    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }


    @PostMapping
    public ResponseEntity<BooksResponse> register(@RequestBody BooksRequest booksRequest){
        BooksResponse books = booksService.cadastrar(booksRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(books);
    }

    @GetMapping
    public ResponseEntity<Page<BooksResponse>>show(@PageableDefault(size = 5, sort = "id")Pageable pageable){
        return ResponseEntity.ok(booksService.mostrar(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BooksResponse> getById(@PathVariable Long id){
        return ResponseEntity.ok(booksService.mostrarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BooksResponse> updateBooks(@PathVariable Long id, @RequestBody BooksRequest booksRequest){
        BooksResponse update = booksService.uptadeLivro(id, booksRequest);
        return ResponseEntity.ok(update);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        booksService.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }



}
