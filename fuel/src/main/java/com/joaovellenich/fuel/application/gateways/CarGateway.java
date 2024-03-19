package com.joaovellenich.fuel.application.gateways;

import java.util.UUID;

public interface CarGateway {
    public void updateCarKm(UUID carId, Double km, String token) throws Exception;
}
