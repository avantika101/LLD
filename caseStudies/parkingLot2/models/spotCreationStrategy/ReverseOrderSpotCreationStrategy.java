package caseStudies.parkingLot2.models.spotCreationStrategy;

import caseStudies.parkingLot.SpotType;
import caseStudies.parkingLot2.models.ParkingSpot;

import java.util.ArrayList;
import java.util.List;

public class ReverseOrderSpotCreationStrategy implements SpotCreationStrategy{
    @Override
    public List<ParkingSpot> createSpots(int num) {
        List<ParkingSpot> spotsList = new ArrayList<>();

        for(int i = num; i >= 1 ; i--){
            spotsList.add(new ParkingSpot(i, SpotType.COMPACT));
        }

        return spotsList;
    }
}
