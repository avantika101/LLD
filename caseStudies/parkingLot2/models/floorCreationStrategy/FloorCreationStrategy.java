package caseStudies.parkingLot2.models.floorCreationStrategy;

import caseStudies.parkingLot2.models.ParkingFloor;

import java.util.List;

public interface FloorCreationStrategy {
    public List<ParkingFloor> createFloors(int numFloors, int numSpots);
}
