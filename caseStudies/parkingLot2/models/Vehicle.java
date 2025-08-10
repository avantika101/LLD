package caseStudies.parkingLot2.models;

import caseStudies.parkingLot2.enums.VehicleType;

public class Vehicle {
    private final String numberPlate;
    private final VehicleType vehicleType;

    Vehicle(String numberPlate, VehicleType type){
        this.numberPlate = numberPlate;
        this.vehicleType = type;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}
