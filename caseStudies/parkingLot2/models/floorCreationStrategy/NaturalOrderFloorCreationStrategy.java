package caseStudies.parkingLot2.models.floorCreationStrategy;

import caseStudies.parkingLot2.models.ParkingFloor;
import caseStudies.parkingLot2.models.spotCreationStrategy.SpotCreationStrategy;

import java.util.ArrayList;
import java.util.List;

public class NaturalOrderFloorCreationStrategy implements FloorCreationStrategy{
    SpotCreationStrategy spotCreationStrategy;

    public NaturalOrderFloorCreationStrategy(SpotCreationStrategy spotCreationStrategy){
        this.spotCreationStrategy = spotCreationStrategy;
    }

    @Override
    public List<ParkingFloor> createFloors(int numFloor, int numSpots) {
        List<ParkingFloor> floorList = new ArrayList<>();

        for(int i = 1; i <= numFloor ; i++){
            floorList.add(new ParkingFloor(i, spotCreationStrategy.createSpots(numSpots)));
        }

        return floorList;
    }
}
