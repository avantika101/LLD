package caseStudies.carRental.model;

import caseStudies.carRental.enums.VehicleEvent;

import java.time.LocalDateTime;
import java.util.UUID;

public class VehicleLog {
    private final UUID logId;
    private final String vehicleId;
    private final LocalDateTime timestamp;
    private final VehicleEvent eventType;
    private final String description;

    public VehicleLog(String vehicleId, VehicleEvent eventType, String description) {
        this.logId = UUID.randomUUID();
        this.vehicleId = vehicleId;
        this.timestamp = LocalDateTime.now();
        this.eventType = eventType;
        this.description = description;
    }

    public UUID getLogId() {
        return logId;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public VehicleEvent getEventType() {
        return eventType;
    }

    public String getDescription() {
        return description;
    }
}

