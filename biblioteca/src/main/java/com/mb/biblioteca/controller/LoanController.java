package com.mb.biblioteca.controller;

import com.mb.biblioteca.config.SecurityConfig;
import com.mb.biblioteca.dto.request.LoanRequest;
import com.mb.biblioteca.dto.response.LoanResponse;
import com.mb.biblioteca.model.Loan;
import com.mb.biblioteca.service.LoanService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emprestimos")
@Tag(name = "emprestimos", description = "Controlador de emprestimos que os usaurio fizeram na biblioteca")
@SecurityRequirement(name = SecurityConfig.SECURITY)
public class LoanController {
    private final LoanService loanService;


    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping
    public ResponseEntity<LoanResponse> pegarEmprestado(@RequestBody LoanRequest dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(loanService.emprestar(dto));
    }

    @PutMapping("/devolver/{id}")
    public ResponseEntity<LoanResponse> devolver(@PathVariable Long id) {
        return ResponseEntity.ok(loanService.devolver(id));
    }
}

