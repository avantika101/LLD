package caseStudies.carBookingSystem.services;

import caseStudies.carBookingSystem.enums.CabAvailabilityStatus;
import caseStudies.carBookingSystem.models.Cab;
import caseStudies.carBookingSystem.models.Driver;

import java.util.ArrayList;
import java.util.List;

public class CabInventory {

    List<Cab> allCabs;

    CabInventory(){
        allCabs = new ArrayList<>();
    }

    public List<Cab> getAllCabs() {
        return allCabs;
    }

    public void addCab(Cab cab){
        allCabs.add(cab);
    }

    public void removeCab(Cab cab){
        allCabs.remove(cab);
    }


}
