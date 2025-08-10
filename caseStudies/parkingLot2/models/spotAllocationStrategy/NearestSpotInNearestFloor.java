package caseStudies.parkingLot2.models.spotAllocationStrategy;

import caseStudies.parkingLot2.models.ParkingFloor;
import caseStudies.parkingLot2.models.ParkingSpot;

import java.util.List;

public class NearestSpotInNearestFloor implements SpotAllocationStrategy{
    @Override
    public ParkingSpot getAvailableParkingSpot(List<ParkingFloor> floors) {
        for(ParkingFloor floor : floors){
            for(ParkingSpot spot : floor.getSpots()){
                if(spot.isAvailable()) return spot;
            }
        }
        return null;
    }
}
