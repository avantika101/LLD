package caseStudies.carBookingSystem.strategies.CabMatchingStrategy;

import caseStudies.carBookingSystem.models.Cab;
import caseStudies.carBookingSystem.models.Location;
import caseStudies.carBookingSystem.services.CabInventory;
import caseStudies.carBookingSystem.services.CabService;
import caseStudies.carBookingSystem.services.TripService;

public interface CabMatchingStrategy {
    public Cab getCab(CabService cabService, TripService tripService, Location riderLocation);
}
