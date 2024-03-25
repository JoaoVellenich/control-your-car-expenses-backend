package com.joaovellenich.fuel.application.gateways;

import com.joaovellenich.fuel.domain.Fuel;

import java.util.List;
import java.util.UUID;

public interface FuelGateway {
    Fuel createFuel(Fuel fuel);
    Fuel getFuelById(UUID fuelId);
    List<Fuel> getAllFuel(UUID carId);
    void updateFuel(Fuel updateFuel) throws Exception;
}
