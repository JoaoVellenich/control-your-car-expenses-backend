package com.joaovellenich.cars.infra.persistence.repositories;

import com.joaovellenich.cars.infra.persistence.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CarRepository extends JpaRepository<CarEntity, UUID> {
}
