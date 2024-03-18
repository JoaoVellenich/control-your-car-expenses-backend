package com.joaovellenich.fuel.dto.createfuelDTO;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

public record CreateFuelRequest (
        LocalDateTime date,
        Double total_price,
        Double price_per_liter,
        Double liters,
        Double km,
        Double distance,
        UUID carId
) {
}
