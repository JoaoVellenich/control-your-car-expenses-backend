package com.joaovellenich.fuel.infra.persistence.repositories;

import com.joaovellenich.fuel.infra.persistence.entity.FuelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface FuelRepository extends JpaRepository<FuelEntity, UUID> {
    List<FuelEntity> findByCarId(UUID carId);
}
