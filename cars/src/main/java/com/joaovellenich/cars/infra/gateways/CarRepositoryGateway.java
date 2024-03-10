package com.joaovellenich.cars.infra.gateways;

import com.joaovellenich.cars.application.gateways.CarGateway;
import com.joaovellenich.cars.domain.Car;
import com.joaovellenich.cars.infra.persistence.entity.CarEntity;
import com.joaovellenich.cars.infra.persistence.mapper.CarEntityMapper;
import com.joaovellenich.cars.infra.persistence.repositories.CarRepository;

import java.util.List;
import java.util.Optional;
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

    @Override
    public Car getCarById(UUID carId) {
        Optional<CarEntity> carEntity = this.carRepository.findById(carId);
        if(carEntity.isEmpty())
            return null;
        Car carDomain = this.carEntityMapper.toDomain(carEntity.get());
        return carDomain;
    }

    @Override
    public void deleteCar(UUID carId) {
        this.carRepository.deleteById(carId);
    }

    @Override
    public Car updatedCar(Car updatedCar) {
        Optional<CarEntity> carRepo = this.carRepository.findById(updatedCar.id());
        if(carRepo.isEmpty()){
            return null;
        }
        CarEntity carToUpdate = carRepo.get();
        carToUpdate.setBrand(updatedCar.brand());
        carToUpdate.setKm(updatedCar.km());
        carToUpdate.setModel(updatedCar.model());
        carToUpdate.setYear(updatedCar.year());
        CarEntity finishedCar = this.carRepository.save(carToUpdate);
        return this.carEntityMapper.toDomain(finishedCar);
    }
}
