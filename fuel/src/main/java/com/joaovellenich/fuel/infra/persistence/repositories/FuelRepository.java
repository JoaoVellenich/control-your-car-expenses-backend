package com.joaovellenich.fuel.infra.persistence.repositories;

import com.joaovellenich.fuel.infra.persistence.entity.FuelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FuelRepository extends JpaRepository<FuelEntity, UUID> {
}
