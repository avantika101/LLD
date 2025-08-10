package caseStudies.parkingLot2.models;

import java.util.ArrayList;
import java.util.List;

public class ParkingFloor {

    private final int floorNum;
    private List<ParkingSpot> spots;
    private CustomerInfoPortal portal;

    public ParkingFloor(int id, List<ParkingSpot> spots){
        this.floorNum = id;
        this.spots = spots;
    }

    public List<ParkingSpot> getSpots(){
        return this.spots;
    }

    public void setCustomerInfoPortal(CustomerInfoPortal customerInfoPortal){
        this.portal = customerInfoPortal;
    }

    public CustomerInfoPortal getPortal(){
        return this.portal;
    }

    public boolean isCustomerInfoPortalAvailable(){
        return portal != null;
    }


}
