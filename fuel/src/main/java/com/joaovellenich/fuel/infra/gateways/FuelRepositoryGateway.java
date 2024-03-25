package com.joaovellenich.fuel.infra.gateways;

import com.joaovellenich.fuel.application.gateways.FuelGateway;
import com.joaovellenich.fuel.domain.Fuel;
import com.joaovellenich.fuel.infra.persistence.entity.FuelEntity;
import com.joaovellenich.fuel.infra.persistence.mapper.FuelEntityMapper;
import com.joaovellenich.fuel.infra.persistence.repositories.FuelRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class FuelRepositoryGateway implements FuelGateway {
    private final FuelRepository fuelRepository;
    private final FuelEntityMapper fuelEntityMapper;

    public FuelRepositoryGateway(FuelRepository fuelRepository, FuelEntityMapper fuelEntityMapper){
        this.fuelRepository = fuelRepository;
        this.fuelEntityMapper = fuelEntityMapper;
    }

    @Override
    public Fuel createFuel(Fuel fuel) {
        FuelEntity fuelEntity = this.fuelEntityMapper.toEntity(fuel);
        FuelEntity savedFuel = this.fuelRepository.save(fuelEntity);
        return this.fuelEntityMapper.toDomain(savedFuel);
    }

    @Override
    public List<Fuel> getAllFuel(UUID carId) {
        List<FuelEntity> fuelsEntity = this.fuelRepository.findByCarId(carId);
        List<Fuel> fuelsDomain = fuelsEntity.stream().map(this.fuelEntityMapper::toDomain).collect(Collectors.toList());
        return fuelsDomain;
    }
}
