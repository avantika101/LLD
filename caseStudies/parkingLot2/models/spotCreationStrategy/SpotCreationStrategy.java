package caseStudies.parkingLot2.models.spotCreationStrategy;

import caseStudies.parkingLot2.models.ParkingSpot;

import java.util.List;

public interface SpotCreationStrategy {
    public List<ParkingSpot> createSpots(int num);
}
