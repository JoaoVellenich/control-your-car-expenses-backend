package com.joaovellenich.fuel.application.usecases;

import com.joaovellenich.fuel.application.gateways.CarGateway;
import com.joaovellenich.fuel.application.gateways.FuelGateway;
import com.joaovellenich.fuel.domain.Fuel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

public class EditFuelUseCase {
    private final static Logger logger = LoggerFactory.getLogger(EditFuelUseCase.class);
    private final FuelGateway fuelGateway;

    public EditFuelUseCase(FuelGateway fuelGateway){
        this.fuelGateway = fuelGateway;
    }

    public Fuel editFuel(UUID fuelId, Fuel updateFuelData) throws Exception {
        logger.info("Start editFuel UseCase - FuelId - " + fuelId);
        Fuel fuel = this.fuelGateway.getFuelById(fuelId);
        if (fuel == null) {
            throw new Exception("Fuel not found with id - " + fuelId);
        }
        Fuel updatedFuel = Fuel.builder()
                .id(fuelId)
                .date(updateFuelData.date())
                .total_price(updateFuelData.total_price())
                .price_per_liter(updateFuelData.total_price())
                .liters(updateFuelData.liters())
                .km(updateFuelData.km())
                .distance(updateFuelData.distance())
                .carId(fuel.carId())
                .build();
        this.fuelGateway.updateFuel(updatedFuel);
        logger.info("Finished editFUel UseCase - Response - " + updatedFuel);
        return updatedFuel;
    }
}
