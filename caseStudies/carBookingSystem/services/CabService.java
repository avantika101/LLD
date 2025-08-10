package caseStudies.carBookingSystem.services;

import caseStudies.carBookingSystem.enums.CabAvailabilityStatus;
import caseStudies.carBookingSystem.models.Cab;
import caseStudies.carBookingSystem.models.Driver;

import java.util.ArrayList;
import java.util.List;

public class CabService {
    CabInventory cabInventory;
    List<Cab> allCabsWhichHaveDriver;

    CabService(CabInventory cabInventory){
        this.cabInventory = cabInventory;
        allCabsWhichHaveDriver = new ArrayList<>();
    }

    public void assignDriverToCab(Cab cab, Driver driver){
        cab.setDriver(driver);
    }

    public void unassignDriverFromCab(Cab cab){
        cab.setDriver(null);
        allCabsWhichHaveDriver.remove(cab);
    }

    public List<Cab> getAllCabsWhichHaveDriver() {
        return allCabsWhichHaveDriver;
    }

    public boolean isCabAvailable(Cab cab){
        return cab.getCabStatus().equals(CabAvailabilityStatus.AVAILABLE);
    }

    public void makeCabAvailable(Cab cab){
        cab.setCabStatus(CabAvailabilityStatus.AVAILABLE);
    }

    public void makeCabUnavailable(Cab cab){
        cab.setCabStatus(CabAvailabilityStatus.UNAVAILABLE);
    }

}
