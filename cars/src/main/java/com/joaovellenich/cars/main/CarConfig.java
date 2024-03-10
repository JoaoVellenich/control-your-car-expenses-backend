package com.joaovellenich.cars.main;

import com.joaovellenich.cars.application.gateways.CarGateway;
import com.joaovellenich.cars.application.usecases.CreateCarUseCase;
import com.joaovellenich.cars.application.usecases.DeleteCarUseCase;
import com.joaovellenich.cars.application.usecases.GetCarByOwnerIdUseCase;
import com.joaovellenich.cars.application.usecases.UpdateCarUseCase;
import com.joaovellenich.cars.dto.createcarDTO.CreateCarDTOMapper;
import com.joaovellenich.cars.dto.getcarsDTO.GetCarsDTOMapper;
import com.joaovellenich.cars.dto.updatecarDTO.UpdateCarDTOMapper;
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
    public GetCarByOwnerIdUseCase getCarByOwnerIdUseCase(CarGateway carGateway){return new GetCarByOwnerIdUseCase(carGateway);}
    @Bean
    public DeleteCarUseCase deleteCarUseCase(CarGateway carGateway){
        return new DeleteCarUseCase(carGateway);
    }
    @Bean
    public UpdateCarUseCase updateCarUseCase(CarGateway carGateway){return new UpdateCarUseCase(carGateway);}
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

    @Bean
    public GetCarsDTOMapper getCarsDTOMapper(){return new GetCarsDTOMapper();}

    @Bean
    public UpdateCarDTOMapper updateCarDTOMapper(){return new UpdateCarDTOMapper();}
}
