package caseStudies.parkingLot2.models.spotAllocationStrategy;

import caseStudies.parkingLot2.models.ParkingFloor;
import caseStudies.parkingLot2.models.ParkingSpot;

import java.util.List;

public interface SpotAllocationStrategy {
    public ParkingSpot getAvailableParkingSpot(List<ParkingFloor> floors);
}
