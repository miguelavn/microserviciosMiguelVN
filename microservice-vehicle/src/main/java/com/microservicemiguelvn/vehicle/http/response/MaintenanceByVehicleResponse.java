package com.microservicemiguelvn.vehicle.http.response;

import com.microservicemiguelvn.vehicle.dto.MaintenanceDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MaintenanceByVehicleResponse {
    private String vehicleBrand;
    private String vehicleModel;
    private String vehicleLicensePlate;

    private List<MaintenanceDTO> maintenanceDTOList;
}
