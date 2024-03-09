package com.joaovellenich.cars.application.usecases;

import com.joaovellenich.cars.application.gateways.CarGateway;
import com.joaovellenich.cars.domain.Car;

public class CreateCarUseCase {
    private final CarGateway carGateway;

    public CreateCarUseCase(CarGateway carGateway){
        this.carGateway = carGateway;
    }
    public Car createCar(Car car){
        return this.carGateway.createCar(car);
    }
}
