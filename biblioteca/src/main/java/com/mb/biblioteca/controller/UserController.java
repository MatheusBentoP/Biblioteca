package com.mb.biblioteca.controller;

import com.mb.biblioteca.dto.request.UserRegisterRequest;
import com.mb.biblioteca.dto.response.UserRegisterResponse;
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

//    private final UserService userService;
//
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @PostMapping
//    public ResponseEntity<UserRegisterResponse> register(@RequestBody UserRegisterRequest userRegisterRequest){
//        UserRegisterResponse user = userService.cadastrarAlunos(userRegisterRequest);
//        return ResponseEntity.status(HttpStatus.CREATED).body(user);
//    }
//
//    @GetMapping
//    public ResponseEntity<Page<UserRegisterResponse>>show(@PageableDefault(size = 5, sort = "id") Pageable pageable){
//        return ResponseEntity.ok(userService.mostrar(pageable));
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<UserRegisterResponse> getById(@PathVariable Long id){
//        return ResponseEntity.ok(userService.mostrarPorId(id));
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<UserRegisterResponse> updateBooks(@PathVariable Long id, @RequestBody UserRegisterRequest userRegisterRequest){
//        UserRegisterResponse update = userService.uptadeAluno(id, userRegisterRequest);
//        return ResponseEntity.ok(update);
//    }



}
