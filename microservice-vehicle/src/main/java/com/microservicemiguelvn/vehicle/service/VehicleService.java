package com.microservicemiguelvn.vehicle.service;

import com.microservicemiguelvn.vehicle.http.response.MaintenanceByVehicleResponse;
import com.microservicemiguelvn.vehicle.model.Vehicle;

import java.util.List;
import java.util.Optional;

public interface VehicleService {

    List<Vehicle> getAllVehicles();

    List<Vehicle> getActiveVehicles();

    Optional<Vehicle> getVehicleById(Long id);

    Optional<Vehicle> getVehicleByLicensePlate(String licensePlate);

    Vehicle saveVehicle(Vehicle vehicle);

    void deleteVehicle(Long id);

    MaintenanceByVehicleResponse findMaintenanceByVehicleId(Long vehicleId);

    
}
