package caseStudies.carBookingSystem.services;

import caseStudies.carBookingSystem.models.Cab;
import caseStudies.carBookingSystem.models.Location;
import caseStudies.carBookingSystem.models.Rider;
import caseStudies.carBookingSystem.models.Trip;
import caseStudies.carBookingSystem.strategies.CabMatchingStrategy.CabMatchingService;

import java.util.UUID;

public class CabBookingService {

    private TripService tripService;
    private CabInventory cabInventory;
    private DriverInventory driverInventory;
    private CabMatchingService cabMatchingService;
    private CabService cabService;

    public CabBookingService(TripService tripService, CabInventory cabInventory, DriverInventory driverInventory, CabMatchingService cabMatchingService, CabService cabService) {
        this.tripService = tripService;
        this.cabInventory = cabInventory;
        this.driverInventory = driverInventory;
        this.cabMatchingService = cabMatchingService;
        this.cabService = cabService;
    }

    /**
     * book a cab, make a trip, send the trip details to rider
     */
    public Trip bookCab(Rider rider, Location drop){
        Cab cab = cabMatchingService.getBestCab(cabInventory, tripService, rider.getRiderLocation());
        cabService.makeCabUnavailable(cab);
        Trip trip = new Trip(UUID.randomUUID().toString(), cab, rider, drop);
        tripService.startTrip(trip);
        return trip;

    }

    /**
     * cancel the trip
     */
    public void cancelTrip(Trip trip){
        tripService.cancelTrip(trip);
        cabService.makeCabAvailable(trip.getCabDetails());
    }

    /**
     * update location of the trips
     */
    public void updateTripLocation(Trip trip, Location location){
        tripService.updateTrip(trip, location);
    }

    /**
     * complete trips
     * @param trip
     */
    public void completeTrip(Trip trip){
        tripService.completeTrip(trip);
    }

}
