package caseStudies.parkingLot2.models;

import caseStudies.parkingLot2.models.floorCreationStrategy.FloorCreationStrategy;
import caseStudies.parkingLot2.models.spotAllocationStrategy.SpotAllocationStrategy;

import java.util.List;

public class ParkingLot {
    List<ParkingFloor> floors;

    public ParkingLot(int numFloors, int numSpots, FloorCreationStrategy floorCreationStrategy){
        floors = floorCreationStrategy.createFloors(numFloors, numSpots);
    }

    public List<ParkingFloor> getFloors(){
        return this.floors;
    }

}
