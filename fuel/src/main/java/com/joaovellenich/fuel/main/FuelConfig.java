package com.joaovellenich.fuel.main;

import com.joaovellenich.fuel.application.gateways.FuelGateway;
import com.joaovellenich.fuel.infra.gateways.FuelRepositoryGateway;
import com.joaovellenich.fuel.infra.persistence.mapper.FuelEntityMapper;
import com.joaovellenich.fuel.infra.persistence.repositories.FuelRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FuelConfig {
    @Bean
    public FuelGateway fuelGateway(FuelRepository fuelRepository, FuelEntityMapper fuelEntityMapper){
        return new FuelRepositoryGateway(fuelRepository, fuelEntityMapper);
    }
    @Bean
    public FuelEntityMapper fuelEntityMapper(){
        return new FuelEntityMapper();
    }
}
