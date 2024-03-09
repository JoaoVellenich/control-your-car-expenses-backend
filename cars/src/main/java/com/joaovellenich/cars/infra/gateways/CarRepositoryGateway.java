package com.joaovellenich.cars.infra.gateways;

import com.joaovellenich.cars.application.gateways.CarGateway;
import com.joaovellenich.cars.domain.Car;
import com.joaovellenich.cars.infra.persistence.entity.CarEntity;
import com.joaovellenich.cars.infra.persistence.mapper.CarEntityMapper;
import com.joaovellenich.cars.infra.persistence.repositories.CarRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class CarRepositoryGateway implements CarGateway {
    private final CarRepository carRepository;
    private final CarEntityMapper carEntityMapper;

    public CarRepositoryGateway(CarRepository carRepository, CarEntityMapper carEntityMapper){
        this.carRepository = carRepository;
        this.carEntityMapper = carEntityMapper;
    }
    @Override
    public Car createCar(Car car) {
        CarEntity newCarEntity = this.carEntityMapper.toEntity(car);
        CarEntity savedCar = this.carRepository.save(newCarEntity);
        return this.carEntityMapper.toDomain(savedCar);
    }

    @Override
    public List<Car> getCarByOwnerId(UUID ownerId) {
        List<CarEntity> carsEntity = this.carRepository.findByOwnerId(ownerId);
        List<Car> carsDomain = carsEntity.stream().map(carEntityMapper::toDomain).toList();
        return carsDomain;
    }
}
