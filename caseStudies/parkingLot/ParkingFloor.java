package caseStudies.parkingLot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ParkingFloor {

    private static int counter = 0;
    private List<ParkingSpot> spots;
    private final int capacity;
    private final int floorNum;
    private DisplayBoard displayBoard;

    ParkingFloor(Map<SpotType, Integer> spotConfig){

        this.floorNum = ++ParkingFloor.counter;
        this.spots = new ArrayList<>();
        int val = 0;

        for(Map.Entry<SpotType, Integer> spot : spotConfig.entrySet()){
            for(int i = 0; i < spot.getValue() ; i++){
                spots.add(new ParkingSpot(spot.getKey()));
            }
            val += spot.getValue();
        }

        this.capacity = val;

        this.displayBoard = new DisplayBoard(floorNum);

        /**
         * find better way to initialize?
         */
//        for(int i = 1; i <= cap ; i++){
//            spots.add(new ParkingSpot(SpotType.COMPACT));
//        }
//        for(int i = 1; i <= cap ; i++){
//            spots.add(new ParkingSpot(SpotType.LARGE));
//        }
//        for(int i = 1; i <= cap ; i++){
//            spots.add(new ParkingSpot(SpotType.MOTORCYCLE));
//        }
    }

    public ParkingSpot getAvailableSpot(VehicleType vt){
        for(ParkingSpot spot : spots){
            if(spot.isAvailable() && this.isCompatible(spot.getType(), vt)){
                return spot;
            }
        }
        return null;
    }

    private boolean isCompatible(SpotType spotType, VehicleType vehicleType) {
//        System.out.println("spotType:"+spotType+",vehicleType:"+vehicleType);
        return switch (vehicleType) {
            case BIKE -> spotType == SpotType.MOTORCYCLE || spotType == SpotType.COMPACT;
            case AUTO -> spotType == SpotType.COMPACT || spotType == SpotType.LARGE;
            case CAR -> spotType == SpotType.LARGE || spotType == SpotType.COMPACT;
            default -> false;
        };
    }

    public void addSpot(SpotType type){
        if(spots.size() < this.capacity) {
            spots.add(new ParkingSpot(type));
        }else{
            System.out.println("unable to add spot as floor capacity is full");
        }
    }

    public int getFloorNum() {
        return this.floorNum;
    }

    public void showAvailableSpots() {
        displayBoard.showAvailableSpots(spots);
    }
}
