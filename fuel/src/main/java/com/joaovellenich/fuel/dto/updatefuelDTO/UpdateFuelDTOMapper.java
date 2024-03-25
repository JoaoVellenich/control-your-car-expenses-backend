package com.joaovellenich.fuel.dto.updatefuelDTO;

import com.joaovellenich.fuel.domain.Fuel;

import java.util.UUID;

public class UpdateFuelDTOMapper {
    public Fuel toDomain(UpdateFuelRequest request, UUID fuelId){
        return Fuel.builder()
                .id(fuelId)
                .date(request.date())
                .total_price(request.total_price())
                .price_per_liter(request.price_per_liter())
                .liters(request.liters())
                .km(request.km())
                .distance(request.distance())
                .carId(request.carId())
                .build();
    }
}
