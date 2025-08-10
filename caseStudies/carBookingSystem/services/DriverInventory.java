package caseStudies.carBookingSystem.services;

import caseStudies.carBookingSystem.models.Driver;

import java.util.ArrayList;
import java.util.List;

public class DriverInventory {
    private List<Driver> allDrivers;

    public DriverInventory(){
        allDrivers = new ArrayList<>();
    }

    public void addNewDriver(Driver driver){
        allDrivers.add(driver);
    }

    public void removeDriver(Driver driver){
        allDrivers.remove(driver);
    }
}
