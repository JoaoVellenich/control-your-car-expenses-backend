package com.joaovellenich.cars.dto.updatecarDTO;

import java.util.UUID;

public record UpdateCarRequest (
        UUID id,
        String brand,
        String model,
        int year,
        Double km
){
}
