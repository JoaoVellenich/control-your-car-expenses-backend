package com.joaovellenich.fuel.infra.gateways;

import com.joaovellenich.fuel.application.gateways.FuelGateway;
import com.joaovellenich.fuel.infra.persistence.mapper.FuelEntityMapper;
import com.joaovellenich.fuel.infra.persistence.repositories.FuelRepository;

public class FuelRepositoryGateway implements FuelGateway {
    private final FuelRepository fuelRepository;
    private final FuelEntityMapper fuelEntityMapper;

    public FuelRepositoryGateway(FuelRepository fuelRepository, FuelEntityMapper fuelEntityMapper){
        this.fuelRepository = fuelRepository;
        this.fuelEntityMapper = fuelEntityMapper;
    }
}
