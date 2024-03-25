package com.joaovellenich.fuel.dto.updatefuelDTO;

import java.time.LocalDateTime;
import java.util.UUID;

public record UpdateFuelRequest (
        LocalDateTime date,
        Double total_price,
        Double price_per_liter,
        Double liters,
        Double km,
        Double distance,
        UUID carId
) {
}
