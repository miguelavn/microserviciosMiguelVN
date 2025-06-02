package com.microservicemiguelvn.vehicle.Controller;


import com.microservicemiguelvn.vehicle.model.Vehicle;
import com.microservicemiguelvn.vehicle.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;


    @GetMapping
    public ResponseEntity<List<Vehicle>> getAllVehicles() {
        return ResponseEntity.ok(vehicleService.getAllVehicles());
    }


    @GetMapping("/active")
    public ResponseEntity<List<Vehicle>> getActiveVehicles() {
        return ResponseEntity.ok(vehicleService.getActiveVehicles());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable Long id) {
        return vehicleService.getVehicleById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @GetMapping("/plate/{licensePlate}")
    public ResponseEntity<Vehicle> getByLicensePlate(@PathVariable String licensePlate) {
        return vehicleService.getVehicleByLicensePlate(licensePlate)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle vehicle) {
        return ResponseEntity.ok(vehicleService.saveVehicle(vehicle));
    }


    @PutMapping("/{id}")
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable Long id, @RequestBody Vehicle vehicle) {
        return vehicleService.getVehicleById(id)
                .map(existing -> {
                    vehicle.setId(id); // Asegura que se actualiza el vehículo correcto
                    return ResponseEntity.ok(vehicleService.saveVehicle(vehicle));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // cambiar estado activo true/false
    @PatchMapping("/{id}/toggle-active")
    public ResponseEntity<Vehicle> toggleActive(@PathVariable Long id) {
        return vehicleService.getVehicleById(id)
                .map(vehicle -> {
                    vehicle.setActive(!Boolean.TRUE.equals(vehicle.getActive()));
                    return ResponseEntity.ok(vehicleService.saveVehicle(vehicle));
                })
                .orElse(ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable Long id) {
        return vehicleService.getVehicleById(id).map(vehicle -> {
            vehicleService.deleteVehicle(id);
            return ResponseEntity.noContent().<Void>build();
        }).orElse(ResponseEntity.notFound().build());
    }

    //Enpoint para desde el microservicio de vehicle comunicarse con el
    // de manitenance, traer mantenimientos por id del vehiculo
    @GetMapping("/search-maintenance/{vehicleId}")
    public ResponseEntity<?> findMaintenanceByVehicleId(@PathVariable Long vehicleId){
        return  ResponseEntity.ok(vehicleService.findMaintenanceByVehicleId(vehicleId));

    }

}
