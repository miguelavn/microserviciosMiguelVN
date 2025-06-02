package com.microservicemiguelvn.maintenance.controller;

import com.microservicemiguelvn.maintenance.model.Maintenance;
import com.microservicemiguelvn.maintenance.service.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/maintenance")
public class MaintenanceController {

    @Autowired
    private MaintenanceService maintenanceService;

    @PostMapping
    public Maintenance createMaintenance(@RequestBody Maintenance maintenance){
        return maintenanceService.createMaintenance(maintenance);
    }

    @GetMapping
    public List<Maintenance> getAllMaintenance(){
        return maintenanceService.getAllMaintenance();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Maintenance> searchMaintenanceById(@PathVariable("id") Long id){
        return maintenanceService.getMaintenanceById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @GetMapping("/vehicle/id/{id}")
    public List<Maintenance> searchMaintenancesByIdVehicle(@PathVariable("id") Long id){
        return maintenanceService.getMaintenanceByVehicleId(id);
    }


    @DeleteMapping("{id}")
    public void deleteMaintenanceById(@PathVariable("id") Long id){
        maintenanceService.deleteMaintenance(id);
    }




    @GetMapping("/vehicle/plate/{plate}")
    public List<Maintenance> searchMaintenancesByPlate(@PathVariable("plate") String plate){
        return maintenanceService.getMaintenanceByVehiclePlate(plate);
    }

    @GetMapping("/search-by-vehicle/{vehicleId}")
    public ResponseEntity<?> findByIdVehicle(@PathVariable Long vehicleId){
        return ResponseEntity.ok(maintenanceService.getMaintenanceByVehicleId(vehicleId));


    }


    @PutMapping("/{id}")
    public ResponseEntity<Maintenance> updateMaintenance(@PathVariable Long id, @RequestBody Maintenance maintenance) {
        return maintenanceService.getMaintenanceById(id)
                .map(existing -> {
                    maintenance.setId(id);
                    return ResponseEntity.ok(maintenanceService.createMaintenance(maintenance));
                })
                .orElse(ResponseEntity.notFound().build());
    }





}
