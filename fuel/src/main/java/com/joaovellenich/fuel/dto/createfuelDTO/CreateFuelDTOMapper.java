package com.joaovellenich.fuel.dto.createfuelDTO;

import com.joaovellenich.fuel.domain.Fuel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class CreateFuelDTOMapper {
    public Fuel toFuel(CreateFuelRequest request){
        return Fuel.builder()
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
