package com.mb.biblioteca.service;

import com.mb.biblioteca.dto.request.BooksRequest;
import com.mb.biblioteca.dto.response.BooksResponse;
import com.mb.biblioteca.mapper.BooksMapper;
import com.mb.biblioteca.model.Books;
import com.mb.biblioteca.repository.IBooksRepository;
import org.springframework.stereotype.Service;

@Service
public class BooksService {
    private final IBooksRepository booksRepository;

    public BooksService(IBooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public BooksResponse cadastrar(BooksRequest booksRequest){
        Books books = BooksMapper.toEntity(booksRequest);
        Books cadastrado = booksRepository.save(books);
        return BooksMapper.toDto(cadastrado);
    }



}
