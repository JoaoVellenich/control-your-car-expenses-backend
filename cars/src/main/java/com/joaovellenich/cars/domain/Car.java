package com.joaovellenich.cars.domain;

import lombok.Builder;

import java.util.UUID;

@Builder
public record Car(
        UUID id,
        String brand,
        String model,
        int year,
        Double km,
        UUID ownerId
) {
}
