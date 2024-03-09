package com.joaovellenich.cars.infra.persistence.repositories;

import com.joaovellenich.cars.infra.persistence.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, UUID> {
    public List<CarEntity> findByOwnerId(UUID ownerId);
}
