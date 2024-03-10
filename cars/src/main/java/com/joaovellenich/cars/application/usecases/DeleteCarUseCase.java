package com.joaovellenich.cars.application.usecases;

import com.joaovellenich.cars.application.gateways.CarGateway;
import com.joaovellenich.cars.domain.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;
import java.util.UUID;

public class DeleteCarUseCase {
    private static Logger logger = LoggerFactory.getLogger(DeleteCarUseCase.class);
    private final CarGateway carGateway;

    public DeleteCarUseCase(CarGateway carGateway){
        this.carGateway = carGateway;
    }
    public void deleteCar(UUID carId, UUID ownerId) throws Exception{
        logger.info("Start deleteCar useCase - carId : " + carId + " - ownerId : " + ownerId);
        Car car = this.carGateway.getCarById(carId);
        if(car == null) {
            logger.error("Error deleteCar use case - Error - Car not found with id - " + carId);
            throw new Exception("Car not found");
        }
        if(car.ownerId().equals(ownerId)){
            this.carGateway.deleteCar(carId);
        }else{
            logger.error("Error deleteCar useCase - OwnerId of car does not match - loginId : " + ownerId + " - car OwnerId : " + car.ownerId());
            throw new Exception("OwnerId of car does not match - loginId : " + ownerId + " - car OwnerId : " + car.ownerId());
        }
    }
}
