package caseStudies.parkingLot2.models;

import caseStudies.parkingLot.SpotType;

public class ParkingSpot {
    private final int spotNumber;
    private boolean isOcc;
    private SpotType spotType;

    public ParkingSpot(int num, SpotType spotType){
        this.spotNumber = num;
        this.isOcc = false;
        this.spotType = spotType;
    }

    public void occupy(){
        this.isOcc = true;
    }

    public void vacate(){
        this.isOcc = false;
    }

    public int getSpotNumber(){
        return this.spotNumber;
    }

    public boolean isAvailable(){
        return !this.isOcc;
    }

    public SpotType getSpotType() {
        return spotType;
    }

    public void setSpotType(SpotType spotType) {
        this.spotType = spotType;
    }
}
