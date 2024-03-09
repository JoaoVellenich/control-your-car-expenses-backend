package com.joaovellenich.cars.dto.createcarDTO;

import java.util.UUID;

public record CreateCarRequest (
        String brand,
        String model,
        int year,
        Double km
) {
}
