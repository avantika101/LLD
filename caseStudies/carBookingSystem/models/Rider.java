package caseStudies.carBookingSystem.models;

public class Rider {
    private final String riderId;
    private Location riderLocation;

    public Rider(String id, Location location){
        this.riderId = id;
        this.riderLocation = location;
    }

    public String getRiderId() {
        return riderId;
    }

    public Location getRiderLocation() {
        return riderLocation;
    }

    public void setRiderLocation(Location riderLocation) {
        this.riderLocation = riderLocation;
    }
}
