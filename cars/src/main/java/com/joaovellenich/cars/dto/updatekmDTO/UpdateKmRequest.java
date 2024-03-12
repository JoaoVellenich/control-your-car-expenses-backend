package com.joaovellenich.cars.dto.updatekmDTO;

import lombok.Getter;

import java.util.UUID;


public record UpdateKmRequest (
        UUID carId,
        Double km
){
}
