package com.joaovellenich.auth.domain.user.dto;

import com.joaovellenich.auth.domain.user.UserRole;

public record RegisterUserDTO(String email, String password, String name, UserRole role) {
}
