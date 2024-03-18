package com.joaovellenich.fuel.infra.gateways;

import com.joaovellenich.fuel.application.gateways.FuelGateway;
import com.joaovellenich.fuel.domain.Fuel;
import com.joaovellenich.fuel.infra.persistence.entity.FuelEntity;
import com.joaovellenich.fuel.infra.persistence.mapper.FuelEntityMapper;
import com.joaovellenich.fuel.infra.persistence.repositories.FuelRepository;

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
}
