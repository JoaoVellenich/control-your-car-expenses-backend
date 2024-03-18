package com.joaovellenich.fuel.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Setter
@Getter
public record Fuel (
       UUID id,
       LocalDateTime date,
       Double total_price,
       Double price_per_liter,
       Double liters,
       Double km,
       Double distance,
       UUID carId
){
}
