package com.mb.biblioteca.dto.request;

import com.mb.biblioteca.model.Role;

import java.util.Set;

public record UserRequest(String nome, String matricula, Set<Role> role) {
}
