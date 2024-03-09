package com.joaovellenich.cars.infra.persistence.mapper;

import com.joaovellenich.cars.domain.Car;
import com.joaovellenich.cars.infra.persistence.entity.CarEntity;

public class CarEntityMapper {
    public CarEntity toEntity(Car car){
        return CarEntity.builder()
                .model(car.model())
                .brand(car.brand())
                .year(car.year())
                .km(car.km())
                .ownerId(car.ownerId())
                .build();
    }

    public Car toDomain(CarEntity car){
        return Car.builder()
                .id(car.getId())
                .model(car.getModel())
                .brand(car.getBrand())
                .year(car.getYear())
                .km(car.getKm())
                .ownerId(car.getOwnerId())
                .build();
    }
}
