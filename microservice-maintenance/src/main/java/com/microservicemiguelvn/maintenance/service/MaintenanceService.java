package com.microservicemiguelvn.maintenance.service;

import com.microservicemiguelvn.maintenance.model.Maintenance;

import java.util.List;
import java.util.Optional;

public interface MaintenanceService {
    Maintenance createMaintenance(Maintenance maintenance);

    Optional<Maintenance> getMaintenanceById(Long id);

    List<Maintenance> getAllMaintenance();

    void deleteMaintenance(Long id);

    List<Maintenance> getMaintenanceByVehicleId(Long vehicleId);

    List<Maintenance> getMaintenanceByVehiclePlate(String plate);



}
