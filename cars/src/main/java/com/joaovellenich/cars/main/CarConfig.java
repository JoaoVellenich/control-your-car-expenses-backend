package com.joaovellenich.cars.main;

import com.joaovellenich.cars.application.gateways.CarGateway;
import com.joaovellenich.cars.application.usecases.CreateCarUseCase;
import com.joaovellenich.cars.dto.createcarDTO.CreateCarDTOMapper;
import com.joaovellenich.cars.infra.gateways.CarRepositoryGateway;
import com.joaovellenich.cars.infra.persistence.mapper.CarEntityMapper;
import com.joaovellenich.cars.infra.persistence.repositories.CarRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CarConfig {
    @Bean
    public CreateCarUseCase createCarUseCase(CarGateway carGateway){
        return new CreateCarUseCase(carGateway);
    }

    @Bean
    public CarGateway carGateway(CarRepository carRepository, CarEntityMapper carEntityMapper){
        return new CarRepositoryGateway(carRepository, carEntityMapper);
    }

    @Bean
    public CarEntityMapper carEntityMapper(){
        return new CarEntityMapper();
    }

    @Bean
    public CreateCarDTOMapper createCarDTOMapper(){
        return new CreateCarDTOMapper();
    }
}
