package com.joaovellenich.fuel.application.gateways;

import com.joaovellenich.fuel.domain.Fuel;

public interface FuelGateway {
    Fuel createFuel(Fuel fuel);
}
