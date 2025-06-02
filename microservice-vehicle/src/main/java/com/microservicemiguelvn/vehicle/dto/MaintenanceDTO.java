package com.microservicemiguelvn.vehicle.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MaintenanceDTO {

    private int vehicleId;
    private String maintenanceType;
    private String description;
    private LocalDate maintenanceDate;
    private BigDecimal cost;
    private String performedBy;
    private LocalDate createdAt;
}
