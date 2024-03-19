package com.joaovellenich.fuel.application.usecases;

import com.joaovellenich.fuel.application.gateways.CarGateway;
import com.joaovellenich.fuel.application.gateways.FuelGateway;
import com.joaovellenich.fuel.domain.Fuel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateFuelUseCase {
    private final static Logger logger = LoggerFactory.getLogger(CreateFuelUseCase.class);
    private final FuelGateway fuelGateway;
    private final CarGateway carGateway;
    public CreateFuelUseCase(
            FuelGateway fuelGateway,
            CarGateway carGateway
    ){
        this.fuelGateway = fuelGateway;
        this.carGateway = carGateway;
    }

    public Fuel createFuel(Fuel fuel, String token) throws Exception{
        try{
            logger.info("Start createFuel UseCase - Fuel - " + fuel);
            Fuel savedFuel = this.fuelGateway.createFuel(fuel);
            this.carGateway.updateCarKm(fuel.carId(), fuel.km(), token);
            logger.info("Finished createFuel UseCase - SavedFuel - " + savedFuel);
            return savedFuel;
        }catch (Exception error){
            logger.error("Error createFuel UseCase - Error - " + error);
            throw new Exception("Error to create fuel");
        }
    }
}
