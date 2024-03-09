package com.joaovellenich.cars.infra.persistence.mapper;

import com.joaovellenich.cars.domain.User;
import com.joaovellenich.cars.infra.persistence.entity.UserEntity;

public class UserEntityMapper {
    public UserEntity toEntity(User user){
        return UserEntity.builder()
                .id(user.id())
                .email(user.email())
                .name(user.name())
                .password(user.password())
                .role(user.role())
                .build();
    }

    public User toDomain(UserEntity user){
        return User.builder()
                .id(user.getId())
                .email(user.getEmail())
                .name(user.getName())
                .password(user.getPassword())
                .role(user.getRole())
                .build();
    }
}
