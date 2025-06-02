package com.microservicemiguelvn.vehicle.Client;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservicemiguelvn.vehicle.dto.MaintenanceDTO;

@FeignClient(name = "microservice-maintenance", url = "localhost:8080/api/maintenance")
public interface MaintenanceClient {

    @GetMapping("/search-by-vehicle/{vehicleId}")
    List<MaintenanceDTO> findAllMaintenanceByVehicleId(@PathVariable Long vehicleId);
    
}
