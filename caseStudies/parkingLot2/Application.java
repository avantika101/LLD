package caseStudies.parkingLot2;

import caseStudies.parkingLot2.models.ParkingLot;
import caseStudies.parkingLot2.models.floorCreationStrategy.FloorCreationStrategy;
import caseStudies.parkingLot2.models.floorCreationStrategy.NaturalOrderFloorCreationStrategy;
import caseStudies.parkingLot2.models.pricingStrategy.PricingStrategy;
import caseStudies.parkingLot2.models.pricingStrategy.RegularPricingStrategy;
import caseStudies.parkingLot2.models.spotAllocationStrategy.NearestSpotInNearestFloor;
import caseStudies.parkingLot2.models.spotAllocationStrategy.SpotAllocationStrategy;
import caseStudies.parkingLot2.models.spotCreationStrategy.NaturalEqualDistributionSpotCreationStrategy;
import caseStudies.parkingLot2.models.spotCreationStrategy.NaturalOrderSpotCreationStrategy;
import caseStudies.parkingLot2.models.spotCreationStrategy.ReverseOrderSpotCreationStrategy;
import caseStudies.parkingLot2.models.spotCreationStrategy.SpotCreationStrategy;
import caseStudies.parkingLot2.services.ParkingLotService;

public class Application {
    public static void main(String args[]){
        SpotCreationStrategy naturalOrderSpotCreationStrategy = new NaturalOrderSpotCreationStrategy();
        SpotCreationStrategy reverseOrderSpotCreationStrategy = new ReverseOrderSpotCreationStrategy();
        SpotCreationStrategy equalDistributionSpotCreationStrategy = new NaturalEqualDistributionSpotCreationStrategy();

        FloorCreationStrategy naturalOrderFloorCreationStrategy = new NaturalOrderFloorCreationStrategy(naturalOrderSpotCreationStrategy);

        SpotAllocationStrategy spotAllocationStrategy = new NearestSpotInNearestFloor();

        PricingStrategy pricingStrategy = new RegularPricingStrategy();

        ParkingLot lot = new ParkingLot(1, 5, naturalOrderFloorCreationStrategy);

        ParkingLotService service = new ParkingLotService(lot, pricingStrategy, spotAllocationStrategy);

    }
}
