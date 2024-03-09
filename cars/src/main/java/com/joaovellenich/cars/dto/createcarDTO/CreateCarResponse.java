package com.joaovellenich.cars.dto.createcarDTO;

import lombok.Builder;

import java.util.UUID;

@Builder
public record CreateCarResponse (
        UUID id,
        String brand,
        String model,
        int year,
        Double km,
        UUID ownerId
){
}
