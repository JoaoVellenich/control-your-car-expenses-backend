package com.joaovellenich.fuel.domain;

import lombok.Builder;

import java.util.UUID;

@Builder
public record User (
        UUID id,
        String name,
        String email,
        String password,
        UserRole role
) {
}
