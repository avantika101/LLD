package caseStudies.carRental.model;


import caseStudies.carRental.enums.VehicleType;

public class Vehicle {
    private final String numberPlate;
    private final VehicleType vehicleType;
    private StallNumber stall;
    private BarCode barCode;

    public Vehicle(String numberPlate, VehicleType type){
        this.numberPlate = numberPlate;
        this.vehicleType = type;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public StallNumber getStall() {
        return stall;
    }

    public void setStall(StallNumber stall) {
        this.stall = stall;
    }

    public BarCode getBarCode() {
        return barCode;
    }

    public void setBarCode(BarCode barCode) {
        this.barCode = barCode;
    }
}
