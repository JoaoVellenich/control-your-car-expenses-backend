package com.joaovellenich.fuel.main;

import com.joaovellenich.fuel.infra.gateways.UserRepositoryGateway;
import com.joaovellenich.fuel.infra.persistence.repositories.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    @Bean
    UserRepositoryGateway userRepositoryGateway(UserRepository userRepository){
        return new UserRepositoryGateway(userRepository);
    }
}
