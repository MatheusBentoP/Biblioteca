package com.mb.biblioteca.controller;

import com.mb.biblioteca.dto.request.UserRequest;
import com.mb.biblioteca.dto.response.UserResponse;
import com.mb.biblioteca.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponse> register(@RequestBody UserRequest userRequest){
        UserResponse user = userService.cadastrarAlunos(userRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping
    public ResponseEntity<Page<UserResponse>>show(@PageableDefault(size = 5, sort = "id") Pageable pageable){
        return ResponseEntity.ok(userService.mostrar(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getById(@PathVariable Long id){
        return ResponseEntity.ok(userService.mostrarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateBooks(@PathVariable Long id, @RequestBody UserRequest userRequest){
        UserResponse update = userService.uptadeAluno(id, userRequest);
        return ResponseEntity.ok(update);
    }



}
