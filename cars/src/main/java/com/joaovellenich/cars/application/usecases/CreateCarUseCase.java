package com.joaovellenich.cars.application.usecases;

import com.joaovellenich.cars.application.gateways.CarGateway;
import com.joaovellenich.cars.domain.Car;
import com.joaovellenich.cars.infra.controllers.CarController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateCarUseCase {
    private static Logger logger = LoggerFactory.getLogger(CreateCarUseCase.class);
    private final CarGateway carGateway;
    public CreateCarUseCase(CarGateway carGateway){
        this.carGateway = carGateway;
    }
    public Car createCar(Car car){
        logger.info("Start creatingCar UseCase - Car - " + car);
        return this.carGateway.createCar(car);
    }
}
