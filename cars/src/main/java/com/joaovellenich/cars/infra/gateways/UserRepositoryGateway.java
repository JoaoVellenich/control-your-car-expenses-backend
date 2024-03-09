package com.joaovellenich.cars.infra.gateways;

import com.joaovellenich.cars.domain.User;
import com.joaovellenich.cars.infra.persistence.entity.UserEntity;
import com.joaovellenich.cars.infra.persistence.mapper.UserEntityMapper;
import com.joaovellenich.cars.infra.persistence.repositories.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;

public class UserRepositoryGateway {
    private final UserRepository userRepository;
    public UserRepositoryGateway(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public UserDetails findByEmail(String email){
        return this.userRepository.findByEmail(email);
    }
}
