package com.joaovellenich.fuel.infra.persistence.mapper;

import com.joaovellenich.fuel.domain.Fuel;
import com.joaovellenich.fuel.infra.persistence.entity.FuelEntity;

public class FuelEntityMapper {
    private FuelEntity toEntity(Fuel fuelDomain){
        return FuelEntity.builder()
                .date(fuelDomain.date())
                .total_price(fuelDomain.total_price())
                .price_per_liter(fuelDomain.price_per_liter())
                .liters(fuelDomain.liters())
                .km(fuelDomain.km())
                .distance(fuelDomain.distance())
                .carId(fuelDomain.carId())
                .build();
    }
    private Fuel toDomain(FuelEntity fuelEntity){
        return  Fuel.builder()
                .id(fuelEntity.getId())
                .date(fuelEntity.getDate())
                .total_price(fuelEntity.getTotal_price())
                .price_per_liter(fuelEntity.getPrice_per_liter())
                .liters(fuelEntity.getLiters())
                .km(fuelEntity.getKm())
                .distance(fuelEntity.getDistance())
                .carId(fuelEntity.getCarId())
                .build();
    }
}
