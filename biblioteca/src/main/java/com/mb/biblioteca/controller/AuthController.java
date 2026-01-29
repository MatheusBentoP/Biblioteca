package com.mb.biblioteca.controller;

import com.mb.biblioteca.config.TokenConfig;
import com.mb.biblioteca.dto.request.LoginRequest;
import com.mb.biblioteca.dto.request.UserRegisterRequest;
import com.mb.biblioteca.dto.response.LoginResponse;
import com.mb.biblioteca.dto.response.UserRegisterResponse;
import com.mb.biblioteca.model.User;
import com.mb.biblioteca.model.enuns.Role;
import com.mb.biblioteca.repository.IUserRepository;
import jakarta.validation.Valid;
import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final IUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final TokenConfig tokenConfig;

    public AuthController(IUserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, TokenConfig tokenConfig) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.tokenConfig = tokenConfig;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest){
        UsernamePasswordAuthenticationToken userAndPass = new UsernamePasswordAuthenticationToken(loginRequest.matricula(), loginRequest.senha());
        Authentication authentication = authenticationManager.authenticate(userAndPass);
        User user = (User)authentication.getPrincipal();
        String token = tokenConfig.generateToken(user);
        return ResponseEntity.ok(new LoginResponse(token));
    }

    @PostMapping("/register")
    public ResponseEntity<UserRegisterResponse> register(@Valid @RequestBody UserRegisterRequest request){
        User newUser = new User();
        newUser.setSenha(passwordEncoder.encode(request.senha()));
        newUser.setMatricula(request.matricula());
        newUser.setNome(request.nome());

        if (request.role() != null){
            newUser.setRoles(Set.of(request.role()));
        }else {
            newUser.setRoles(Set.of(Role.ROLE_USER));
        }
        userRepository.save(newUser);

        return ResponseEntity.status(HttpStatus.CREATED).body(new UserRegisterResponse(newUser.getNome(), newUser.getMatricula()));
    }
}
