package com.joaovellenich.fuel.application.usecases;

import com.joaovellenich.fuel.application.gateways.FuelGateway;
import com.joaovellenich.fuel.domain.Fuel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.UUID;

public class GetAllFuelUseCase {
    private final static Logger logger = LoggerFactory.getLogger(GetAllFuelUseCase.class);
    private final FuelGateway fuelGateway;
    public GetAllFuelUseCase(FuelGateway fuelGateway){
        this.fuelGateway = fuelGateway;
    }

    public List<Fuel> getAllFuel(UUID carId){
        logger.info("Start getAllFuel UseCase - CarId - " + carId);
        List<Fuel> fuels = this.fuelGateway.getAllFuel(carId);
        logger.info("Finished getAllFuel UseCase - Fuels - " + fuels);
        return fuels;
    }
}
