package com.joaovellenich.cars.application.usecases;

import com.joaovellenich.cars.application.gateways.CarGateway;
import com.joaovellenich.cars.domain.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

public class UpdateCarUseCase {
    private static Logger logger = LoggerFactory.getLogger(UpdateCarUseCase.class);
    private final CarGateway carGateway;
    public UpdateCarUseCase(CarGateway carGateway){
        this.carGateway = carGateway;
    }

    public Car updateCar(Car updatedCar, UUID ownerId) throws Exception{
        logger.info("Start updateCar useCase - Car : " + updatedCar);
        Car savedCar = this.carGateway.getCarById(updatedCar.id());
        if(savedCar == null){
            logger.error("Error updateCar useCase - Car not found - " + updatedCar);
            throw new Exception("Car not found - " + updatedCar);
        }
        if(!savedCar.ownerId().equals(ownerId)){
            logger.error("Error updateCar useCase - OwnerId does not match - " + savedCar.ownerId() + " : " + ownerId);
            throw new Exception("OwnerId does not match the car ownerId");
        }
        Car endCar = this.carGateway.updatedCar(updatedCar);
        logger.info("Finished updateCar useCase - updatedCar - " + endCar);
        return endCar;
    }
}
