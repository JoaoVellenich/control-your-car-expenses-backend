package com.joaovellenich.fuel.application.usecases;

import com.joaovellenich.fuel.application.gateways.FuelGateway;
import com.joaovellenich.fuel.domain.Fuel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateFuelUseCase {
    private final static Logger logger = LoggerFactory.getLogger(CreateFuelUseCase.class);
    private final FuelGateway fuelGateway;
    public CreateFuelUseCase(FuelGateway fuelGateway){
        this.fuelGateway = fuelGateway;
    }

    public Fuel createFuel(Fuel fuel){
        logger.info("Start createFuel UseCase - Fuel - " + fuel);
       Fuel savedFuel = this.fuelGateway.createFuel(fuel);
       logger.info("Finished createFuel UseCase - SavedFuel - " + savedFuel);
       return savedFuel;
    }
}
