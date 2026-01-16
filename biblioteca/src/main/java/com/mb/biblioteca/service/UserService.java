package com.mb.biblioteca.service;

import com.mb.biblioteca.dto.request.UserRequest;
import com.mb.biblioteca.dto.response.UserResponse;

import com.mb.biblioteca.mapper.UserMapper;

import com.mb.biblioteca.model.User;
import com.mb.biblioteca.repository.IUserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse cadastrarAlunos(UserRequest userRequest) {
        User aluno = UserMapper.toEntity(userRequest);
        User cadastrado = userRepository.save(aluno);
        return UserMapper.toDto(cadastrado);
    }

    public Page<UserResponse> mostrar(Pageable pageable){
        return userRepository.findAll(pageable).map(UserMapper::toDto);
    }

    public UserResponse mostrarPorId(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
        return UserMapper.toDto(user);
    }


    public UserResponse uptadeAluno(Long id, UserRequest request){
        User usuarioAserAlterado = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
        UserMapper.updateEntity(usuarioAserAlterado,request);

        User Alterado = userRepository.save(usuarioAserAlterado);
        return UserMapper.toDto(usuarioAserAlterado);
    }



}
