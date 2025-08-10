package caseStudies.parkingLot2.models.spotCreationStrategy;

import caseStudies.parkingLot.SpotType;
import caseStudies.parkingLot2.models.ElectricSpot;
import caseStudies.parkingLot2.models.ParkingSpot;

import java.util.ArrayList;
import java.util.List;

public class NaturalEqualDistributionSpotCreationStrategy implements SpotCreationStrategy{
    @Override
    public List<ParkingSpot> createSpots(int num) {
        List<ParkingSpot> spots = new ArrayList<>();

        SpotType[] types = SpotType.values();
        int typeCount = types.length;
        int base = num / typeCount;
        int remainder = num % typeCount;

        int index = 0;
        for (SpotType type : types) {
//            if(type.equals(SpotType.ELECTRIC)) continue;
            int count = base + (index < remainder ? 1 : 0); // distribute remainder
            for (int i = 0; i < count; i++) {
                spots.add(createSpot(type, i));
            }
            index++;
        }

        return spots;
    }

    private ParkingSpot createSpot(SpotType type, int spotId) {

        return switch (type) {
            case COMPACT -> new ParkingSpot(spotId, SpotType.COMPACT);
            case LARGE -> new ParkingSpot(spotId, SpotType.LARGE);
            case HANDICAPPED ->  new ParkingSpot(spotId, SpotType.HANDICAPPED);
            case SMALL -> new ParkingSpot(spotId, SpotType.SMALL);
            case MOTORCYCLE -> new ParkingSpot(spotId, SpotType.MOTORCYCLE);
//            default -> throw new IllegalStateException("Unexpected value: " + type);
            case ELECTRIC -> new ElectricSpot(spotId, SpotType.ELECTRIC);
        };
    }
}
