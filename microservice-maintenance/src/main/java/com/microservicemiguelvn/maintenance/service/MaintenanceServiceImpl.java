package com.microservicemiguelvn.maintenance.service;

import com.microservicemiguelvn.maintenance.model.Maintenance;
import com.microservicemiguelvn.maintenance.repository.MaintenanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
@Service
public class MaintenanceServiceImpl implements MaintenanceService {

    @Autowired
    private MaintenanceRepository maintenanceRepository;

    @Override
    public Maintenance createMaintenance(Maintenance maintenance) {
        return maintenanceRepository.save(maintenance);
    }

    @Override
    public Optional<Maintenance> getMaintenanceById(Long id) {
        return maintenanceRepository.findById(id);
    }



    @Override
    public List<Maintenance> getAllMaintenance() {
        return maintenanceRepository.findAll();
    }

    @Override
    public void deleteMaintenance(Long id) {
        maintenanceRepository.deleteById(id);
    }

    @Override
    public List<Maintenance> getMaintenanceByVehicleId(Long vehicleId) {
        return maintenanceRepository.findByVehicleId(vehicleId);
    }



    @Override
    public List<Maintenance> getMaintenanceByVehiclePlate(String plate) {
        return maintenanceRepository.findByVehiclePlate(plate);
    }





}
