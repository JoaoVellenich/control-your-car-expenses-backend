package com.joaovellenich.fuel.domain;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
public record Fuel (
       UUID id,
       LocalDateTime cate,
       Double total_price,
       Double price_per_liter,
       Double liters,
       Double km,
       Double distance,
       UUID carId
){
}
