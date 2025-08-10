package caseStudies.carBookingSystem.models;

import caseStudies.carBookingSystem.enums.TripStatus;

import java.time.LocalDateTime;

public class Trip {
    private final String tripId;
    private final Cab cab;
    private final Rider riderId;
    private final Location pickup;
    private final Location destination;
    private final LocalDateTime bookedOn;
    private Location currentLocation;
    private TripStatus tripStatus;

    public Trip(String tripId, Cab cab, Rider riderId, Location destination) {
        this.tripId = tripId;
        this.cab = cab;
        this.riderId = riderId;
        this.pickup = riderId.getRiderLocation();
        this.destination = destination;
        this.bookedOn = LocalDateTime.now();
        this.tripStatus = TripStatus.ACTIVE;
    }

    public void updateCurrentLocation(Location location){
        this.currentLocation = location;
    }

    public void cancelTrip(){
        this.tripStatus = TripStatus.CANCELED;
    }

    public void completeTrip(){
        this.tripStatus = TripStatus.COMPLETED;
    }

    public Cab getCabDetails(){
        return cab;
    }

    public String getTripId() {
        return tripId;
    }

    public String getDriverId() {
        return cab.getDriver().getDriverId();
    }

    public String getRiderId() {
        return riderId.getRiderId();
    }

    public Location getPickup() {
        return pickup;
    }

    public Location getDestination() {
        return destination;
    }

    public LocalDateTime getBookedOn() {
        return bookedOn;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public TripStatus getTripStatus() {
        return tripStatus;
    }
}
