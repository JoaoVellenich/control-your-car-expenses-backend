package com.joaovellenich.cars.main;

import com.joaovellenich.cars.infra.gateways.UserRepositoryGateway;
import com.joaovellenich.cars.infra.persistence.mapper.UserEntityMapper;
import com.joaovellenich.cars.infra.persistence.repositories.UserRepository;
import com.joaovellenich.cars.infra.security.TokenService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    @Bean
    UserRepositoryGateway userRepositoryGateway(UserRepository userRepository){
        return new UserRepositoryGateway(userRepository);
    }
}
