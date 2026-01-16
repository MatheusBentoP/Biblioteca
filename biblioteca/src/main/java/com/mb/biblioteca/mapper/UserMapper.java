package com.mb.biblioteca.mapper;

import com.mb.biblioteca.dto.request.UserRequest;
import com.mb.biblioteca.dto.response.UserResponse;
import com.mb.biblioteca.model.User;

public class UserMapper {
    public static User toEntity(UserRequest request){
        User user = new User();
        user.setNome(request.nome());
        user.setMatricula(request.matricula());
        user.setRoles(request.role());
        return user;
    }

    public static UserResponse toDto(User user){
        return new UserResponse(
                user.getId(),
                user.getNome(),
                user.getMatricula(),
                user.getEmprestimos().stream()
                        .map(LoanMapper::toDto)
                        .toList()
        );
    }

    public static void updateEntity(User user, UserRequest request){
        user.setNome(request.nome());
        user.setMatricula(request.matricula());
    }

}
