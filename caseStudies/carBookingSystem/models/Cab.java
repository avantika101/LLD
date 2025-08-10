package caseStudies.carBookingSystem.models;

import caseStudies.carBookingSystem.enums.CabAvailabilityStatus;

public class Cab {
    private final String cabId;
    private Driver driver;
    private Location currentLocation;
    private CabAvailabilityStatus cabStatus;

    public Cab(String id){
        this.cabId = id;
    }

    public String getCabId() {
        return cabId;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void updateCurrentLocation(Location location) {
        this.currentLocation = location;
    }

    public CabAvailabilityStatus getCabStatus() {
        return cabStatus;
    }

    public void setCabStatus(CabAvailabilityStatus status){
        this.cabStatus = status;
    }
}
