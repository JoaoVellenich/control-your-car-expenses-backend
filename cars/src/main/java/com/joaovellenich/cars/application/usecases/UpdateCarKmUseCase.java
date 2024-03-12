package com.joaovellenich.cars.application.usecases;

import com.joaovellenich.cars.application.gateways.CarGateway;
import com.joaovellenich.cars.domain.Car;

import java.util.UUID;

public class UpdateCarKmUseCase {
    private final CarGateway carGateway;

    public UpdateCarKmUseCase(CarGateway carGateway){
        this.carGateway = carGateway;
    }

    public Car UpdateCarKm(UUID carId, UUID ownerId, Double newKm) throws Exception{
        Car car = this.carGateway.getCarById(carId);
        if(car == null){
            throw new Exception("Car not found - carId : " + carId);
        }
        if(!car.ownerId().equals(ownerId)){
            throw new Exception("Car owner id does not match the logged in user - " + car.ownerId() + " - " + ownerId);
        }
        Car updatedCar = Car.builder()
                .id(car.id())
                .brand(car.brand())
                .model(car.model())
                .year(car.year())
                .ownerId(car.ownerId())
                .km(newKm)
                .build();
        return this.carGateway.updatedCar(updatedCar);
    }
}
