package caseStudies.parkingLot;

public class Vehicle {

    private final String numberPlate;
    private final VehicleType type;

    public Vehicle(String plate, VehicleType type){
        this.numberPlate = plate;
        this.type = type;
    }

    public String getNumberPlate(){
        return this.numberPlate;
    }

    public VehicleType getType(){
        return this.type;
    }
}
