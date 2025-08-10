package caseStudies.carBookingSystem.services;

import caseStudies.carBookingSystem.models.Location;
import caseStudies.carBookingSystem.models.Rider;
import caseStudies.carBookingSystem.models.Trip;

import java.util.ArrayList;
import java.util.List;

public class TripService {
    List<Trip> allTrips;
    List<Trip> allActiveTrips;

    public TripService(){
        allTrips = new ArrayList<>();
        allActiveTrips = new ArrayList<>();
    }

    public void startTrip(Trip trip){
        allTrips.add(trip);
        allActiveTrips.add(trip);
    }

    public void cancelTrip(Trip trip){
        trip.cancelTrip();
        allActiveTrips.remove(trip);
    }

    public void completeTrip(Trip trip){
        trip.completeTrip();
        allActiveTrips.remove(trip);
    }

    public List<Trip> getAllTripsForARider(String rider){
        List<Trip> trips = new ArrayList<>();
        for(Trip trip : allTrips){
            if(trip.getRiderId().equals(rider)){
                trips.add(trip);
            }
        }
        return trips;
    }

    public void updateTrip(Trip trip, Location location){
        trip.updateCurrentLocation(location);
    }
}
