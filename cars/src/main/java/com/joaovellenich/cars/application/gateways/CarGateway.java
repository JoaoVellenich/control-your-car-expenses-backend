package com.joaovellenich.cars.application.gateways;

import com.joaovellenich.cars.domain.Car;

public interface CarGateway {
    public Car createCar(Car car);
}
