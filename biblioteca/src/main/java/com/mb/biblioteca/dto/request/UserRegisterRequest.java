package com.mb.biblioteca.dto.request;

import com.mb.biblioteca.model.enuns.Role;
import jakarta.validation.constraints.NotEmpty;

public record UserRegisterRequest(@NotEmpty String nome,
                                  @NotEmpty String matricula,
                                  @NotEmpty String senha,
                                  Role role) {
}
