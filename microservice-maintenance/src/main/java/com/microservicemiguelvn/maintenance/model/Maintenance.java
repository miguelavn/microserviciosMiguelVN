package com.microservicemiguelvn.maintenance.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Builder
@Table(name = "vehicles_maintenance")
@AllArgsConstructor
@NoArgsConstructor
public class Maintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "vehicle_id")
    private int vehicleId;

    @Column(name = "maintenance_type")
    private String maintenanceType;
    private String description;
    @Column(name = "maintenance_date")
    private LocalDate maintenanceDate;
    private BigDecimal cost;
    @Column(name = "performed_by")
    private String performedBy;
    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDate createdAt;
}
