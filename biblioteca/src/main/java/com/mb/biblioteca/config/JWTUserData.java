package com.mb.biblioteca.config;


import lombok.Builder;

import java.util.List;


@Builder
public record JWTUserData(Long userId, String matricula, List<String> roles){
}
