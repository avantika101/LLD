package caseStudies.carRental.services;

import caseStudies.carRental.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleInventory {
    List<Vehicle> allVehicles;

    public VehicleInventory(){
        this.allVehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle veh){
        this.allVehicles.add(veh);
    }

    public void removeVehicle(Vehicle veh){
        allVehicles.remove(veh);
    }

    public List<Vehicle> getAllVehicles() {
        return allVehicles;
    }
}
