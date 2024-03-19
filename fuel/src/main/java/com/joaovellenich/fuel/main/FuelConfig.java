package com.joaovellenich.fuel.main;

import com.joaovellenich.fuel.application.gateways.CarGateway;
import com.joaovellenich.fuel.application.gateways.FuelGateway;
import com.joaovellenich.fuel.application.usecases.CreateFuelUseCase;
import com.joaovellenich.fuel.dto.createfuelDTO.CreateFuelDTOMapper;
import com.joaovellenich.fuel.infra.gateways.CarRepositoryGateway;
import com.joaovellenich.fuel.infra.gateways.FuelRepositoryGateway;
import com.joaovellenich.fuel.infra.persistence.mapper.FuelEntityMapper;
import com.joaovellenich.fuel.infra.persistence.repositories.FuelRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class FuelConfig {
    @Bean
    public CreateFuelUseCase createFuelUseCase(FuelGateway fuelGateway, CarGateway carGateway){
        return new CreateFuelUseCase(fuelGateway, carGateway);
    }
    @Bean
    public FuelGateway fuelGateway(FuelRepository fuelRepository, FuelEntityMapper fuelEntityMapper){
        return new FuelRepositoryGateway(fuelRepository, fuelEntityMapper);
    }
    @Bean
    public CarGateway carGateway(){
        return new CarRepositoryGateway();
    }
    @Bean
    public FuelEntityMapper fuelEntityMapper(){
        return new FuelEntityMapper();
    }
    @Bean
    public CreateFuelDTOMapper createFuelDTOMapper(){
        return new CreateFuelDTOMapper();
    }
}
