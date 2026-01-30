package com.mb.biblioteca.service;

import com.mb.biblioteca.config.JWTUserData;
import com.mb.biblioteca.dto.request.LoanRequest;
import com.mb.biblioteca.dto.response.LoanResponse;
import com.mb.biblioteca.mapper.LoanMapper;
import com.mb.biblioteca.model.Books;
import com.mb.biblioteca.model.Loan;
import com.mb.biblioteca.model.User;
import com.mb.biblioteca.model.enuns.LoanStatus;
import com.mb.biblioteca.repository.IBooksRepository;
import com.mb.biblioteca.repository.ILoanRepository;
import com.mb.biblioteca.repository.IUserRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class LoanService {
    private final ILoanRepository loanRepository;
    private final IBooksRepository booksRepository;
    private final IUserRepository userRepository;

    public LoanService(ILoanRepository loanRepository, IBooksRepository booksRepository, IUserRepository userRepository) {
        this.loanRepository = loanRepository;
        this.booksRepository = booksRepository;
        this.userRepository = userRepository;
    }


    @Transactional
    public LoanResponse emprestar(LoanRequest loanRequest){

       Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        JWTUserData jwtUserData = (JWTUserData) authentication.getPrincipal();

        User usuario = userRepository.findById(jwtUserData.userId())
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));

        Books books = booksRepository.findById(loanRequest.livroId())
                .orElseThrow(() ->new RuntimeException("Livro não encontrado"));

       if (loanRepository.existsByLivrosAndStatus(books, LoanStatus.ATIVO)){
           throw new RuntimeException("Livro já está emprestado");
       }


       long ativo = loanRepository.countByAlunosAndStatus(usuario, LoanStatus.ATIVO);


       if (ativo >= 3){
           throw new RuntimeException("limite de emprestimo atingido");
       }
       Loan emprestimo =new Loan();
       emprestimo.setLivros(books);
       emprestimo.setAlunos(usuario);
       emprestimo.setDataEmprestimo(LocalDate.now());
       emprestimo.setDataDevolucao(LocalDate.now().plusDays(3));
       emprestimo.setStatus(LoanStatus.ATIVO);

        Loan salvo = loanRepository.save(emprestimo);

        return LoanMapper.toDto(salvo);
    }

    @Transactional
    public LoanResponse devolver(Long id){
        Loan emprestimo = loanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Emprestimo não encontrado"));

        emprestimo.setStatus(LoanStatus.DEVOLVIDO);
        emprestimo.setDataDevolucao(LocalDate.now());

        return LoanMapper.toDto(emprestimo);
    }





}
