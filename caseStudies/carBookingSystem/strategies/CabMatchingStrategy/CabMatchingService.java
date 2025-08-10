package caseStudies.carBookingSystem.strategies.CabMatchingStrategy;

import caseStudies.carBookingSystem.models.Cab;
import caseStudies.carBookingSystem.models.Location;
import caseStudies.carBookingSystem.services.CabInventory;
import caseStudies.carBookingSystem.services.TripService;

public class CabMatchingService {
    private CabMatchingStrategy cabMatchingStrategy;

    public CabMatchingService(){
        cabMatchingStrategy = new DefaultCabMatchingStrategy();
    }

    public Cab getBestCab(CabInventory cabInventory, TripService tripService, Location riderLocation){
        return cabMatchingStrategy.getCab(cabInventory, tripService, riderLocation);
    }

    public CabMatchingStrategy getCabMatchingStrategy() {
        return cabMatchingStrategy;
    }

    public void setCabMatchingStrategy(CabMatchingStrategy cabMatchingStrategy) {
        this.cabMatchingStrategy = cabMatchingStrategy;
    }
}
