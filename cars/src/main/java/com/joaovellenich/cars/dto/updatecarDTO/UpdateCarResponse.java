package com.joaovellenich.cars.dto.updatecarDTO;

import lombok.Builder;

import java.util.UUID;

@Builder
public record UpdateCarResponse(
        UUID id,
        String brand,
        String model,
        int year,
        Double km,
        UUID ownerId
) {

}
