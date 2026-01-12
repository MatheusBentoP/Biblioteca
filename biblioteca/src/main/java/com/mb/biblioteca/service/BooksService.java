package com.mb.biblioteca.service;

import com.mb.biblioteca.dto.request.BooksRequest;
import com.mb.biblioteca.dto.response.BooksResponse;
import com.mb.biblioteca.mapper.BooksMapper;
import com.mb.biblioteca.model.Books;
import com.mb.biblioteca.repository.IBooksRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.stream.Collectors;

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


    public Page<BooksResponse> mostrar(Pageable pageable){
        return booksRepository.findAll(pageable).map(BooksMapper::toDto);
    }

    public BooksResponse mostrarPorId(Long id){
        Books books = booksRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));
        return BooksMapper.toDto(books);
    }


    public BooksResponse uptadeLivro(Long id, BooksRequest request){
        Books livroAserAlterado = booksRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));
            BooksMapper.updadetoEntity(livroAserAlterado,request);

            Books LivroAlterado = booksRepository.save(livroAserAlterado);
            return BooksMapper.toDto(livroAserAlterado);
    }

    public void deletarPorId(Long id){
        if (!booksRepository.existsById(id)){
            throw new RuntimeException("Livro não encontrado");
        }
        booksRepository.deleteById(id);
    }





}
