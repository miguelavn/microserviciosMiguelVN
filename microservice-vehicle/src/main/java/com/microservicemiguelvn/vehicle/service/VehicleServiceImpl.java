package com.microservicemiguelvn.vehicle.service;

import com.microservicemiguelvn.vehicle.Client.MaintenanceClient;
import com.microservicemiguelvn.vehicle.dto.MaintenanceDTO;
import com.microservicemiguelvn.vehicle.http.response.MaintenanceByVehicleResponse;
import com.microservicemiguelvn.vehicle.model.Vehicle;
import com.microservicemiguelvn.vehicle.repository.VehiclesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {



    @Autowired
    private final VehiclesRepository vehicleRepository;

    @Autowired
    private MaintenanceClient maintenanceClient;

    @Autowired
    public VehicleServiceImpl(VehiclesRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    @Override
    public List<Vehicle> getActiveVehicles() {
        return vehicleRepository.findByActive(true);
    }

    @Override
    public Optional<Vehicle> getVehicleById(Long id) {
        return vehicleRepository.findById(id);
    }

    @Override
    public Optional<Vehicle> getVehicleByLicensePlate(String licensePlate) {
        return vehicleRepository.findByLicensePlate(licensePlate);
    }

    @Override
    public Vehicle saveVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public void deleteVehicle(Long id) {
        vehicleRepository.deleteById(id);
    }

    @Override
    public MaintenanceByVehicleResponse findMaintenanceByVehicleId(Long vehicleId) {

        //consultar el vehiculo
        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElse(new Vehicle());
        //obtener los mantenimientos
        List<MaintenanceDTO> maintenanceDTOList = maintenanceClient.findAllMaintenanceByVehicleId(vehicleId);

        return MaintenanceByVehicleResponse.builder()
                .vehicleBrand(vehicle.getBrand())
                .vehicleModel(vehicle.getModel())
                .vehicleLicensePlate(vehicle.getLicensePlate())
                .maintenanceDTOList(maintenanceDTOList)
                .build();
    }

}
