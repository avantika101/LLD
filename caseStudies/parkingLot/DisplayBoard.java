package caseStudies.parkingLot;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class DisplayBoard {
    private final int floorNum;
    public DisplayBoard(int floorNum) {
        this.floorNum = floorNum;
    }

    public void showFullMessage(String msg){
        System.out.println(msg + " on floor : "+floorNum);
    }

    public void showAvailableSpots(List<ParkingSpot> spots) {
        Map<SpotType, Integer> count = new EnumMap<>(SpotType.class);
        for (ParkingSpot spot : spots) {
            if (spot.isAvailable()) {
                count.put(spot.getType(), count.getOrDefault(spot.getType(), 0) + 1);
            }
        }
        System.out.println("[DisplayBoard - Floor " + floorNum + "] Available spots:");
        for (SpotType type : SpotType.values()) {
            System.out.println(type + ": " + count.getOrDefault(type, 0));
        }

    }
}
