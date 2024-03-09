package com.joaovellenich.cars.application.gateways;

import com.joaovellenich.cars.domain.Car;

import java.util.List;
import java.util.UUID;

public interface CarGateway {
    public Car createCar(Car car);
    public List<Car> getCarByOwnerId(UUID ownerId);
}
