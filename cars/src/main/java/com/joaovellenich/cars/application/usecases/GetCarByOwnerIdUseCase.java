package com.joaovellenich.cars.application.usecases;

import com.joaovellenich.cars.application.gateways.CarGateway;
import com.joaovellenich.cars.domain.Car;
import com.joaovellenich.cars.infra.controllers.CarController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.UUID;

public class GetCarByOwnerIdUseCase {
    private static Logger logger = LoggerFactory.getLogger(GetCarByOwnerIdUseCase.class);
    private final CarGateway carGateway;
    public GetCarByOwnerIdUseCase(CarGateway carGateway){
        this.carGateway = carGateway;
    }

    public List<Car> getCarByOwnerId(UUID ownerId){
        logger.info("Start getCarsByOwnerId useCase - UUID - " + ownerId);
        return this.carGateway.getCarByOwnerId(ownerId);
    }
}
