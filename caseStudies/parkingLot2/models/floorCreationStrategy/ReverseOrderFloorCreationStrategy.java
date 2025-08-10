package caseStudies.parkingLot2.models.floorCreationStrategy;

import caseStudies.parkingLot2.models.ParkingFloor;
import caseStudies.parkingLot2.models.spotCreationStrategy.SpotCreationStrategy;

import java.util.ArrayList;
import java.util.List;

public class ReverseOrderFloorCreationStrategy implements FloorCreationStrategy{
    SpotCreationStrategy spotCreationStrategy;

    ReverseOrderFloorCreationStrategy(SpotCreationStrategy spotCreationStrategy){
        this.spotCreationStrategy = spotCreationStrategy;
    }

    @Override
    public List<ParkingFloor> createFloors(int numFloors, int numSpots) {
        List<ParkingFloor> floorList = new ArrayList<>();

        for(int i = numFloors; i >= 1 ; i--){
            floorList.add(new ParkingFloor(i, spotCreationStrategy.createSpots(numSpots)));
        }

        return floorList;
    }
}
