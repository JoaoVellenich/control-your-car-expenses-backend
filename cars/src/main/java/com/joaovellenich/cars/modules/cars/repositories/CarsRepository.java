package com.joaovellenich.cars.modules.cars.repositories;

import com.joaovellenich.cars.modules.cars.entities.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CarsRepository extends JpaRepository<CarEntity, UUID> {
}
