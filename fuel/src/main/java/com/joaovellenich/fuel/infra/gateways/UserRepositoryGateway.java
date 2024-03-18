package com.joaovellenich.fuel.infra.gateways;

import com.joaovellenich.fuel.infra.persistence.repositories.UserRepository;
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
