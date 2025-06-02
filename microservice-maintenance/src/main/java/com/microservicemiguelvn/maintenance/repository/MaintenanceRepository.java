package com.microservicemiguelvn.maintenance.repository;

import com.microservicemiguelvn.maintenance.model.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface MaintenanceRepository extends JpaRepository<Maintenance, Long> {


    List<Maintenance> findByVehicleId(Long vehicleId);

    @Query(value = "SELECT vm.* FROM vehicles_maintenance vm INNER JOIN vehicles v ON vm.vehicle_id = v.id WHERE v.license_plate = :plate", nativeQuery = true)
    List<Maintenance> findByVehiclePlate(@Param("plate") String plate);




}
