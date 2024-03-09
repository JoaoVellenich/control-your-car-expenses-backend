package com.joaovellenich.cars.application.usecases;

import com.joaovellenich.cars.application.gateways.CarGateway;
import com.joaovellenich.cars.domain.Car;

import java.util.List;
import java.util.UUID;

public class GetCarByOwnerIdUseCase {
    private final CarGateway carGateway;

    public GetCarByOwnerIdUseCase(CarGateway carGateway){
        this.carGateway = carGateway;
    }

    public List<Car> getCarByOwnerId(UUID ownerId){
        return this.carGateway.getCarByOwnerId(ownerId);
    }
}
