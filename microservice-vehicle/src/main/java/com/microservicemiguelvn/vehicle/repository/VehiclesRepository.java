package com.microservicemiguelvn.vehicle.repository;

import com.microservicemiguelvn.vehicle.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VehiclesRepository extends JpaRepository<Vehicle, Long> {

    List<Vehicle> findAll();

    List<Vehicle> findByActive(Boolean active);

    Optional<Vehicle> findByLicensePlate(String licensePlate);

}
