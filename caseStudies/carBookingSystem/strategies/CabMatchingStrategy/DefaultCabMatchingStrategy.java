package caseStudies.carBookingSystem.strategies.CabMatchingStrategy;

import caseStudies.carBookingSystem.enums.CONSTANTS;
import caseStudies.carBookingSystem.models.Cab;
import caseStudies.carBookingSystem.models.Location;
import caseStudies.carBookingSystem.models.Rider;
import caseStudies.carBookingSystem.services.CabInventory;
import caseStudies.carBookingSystem.services.CabService;
import caseStudies.carBookingSystem.services.TripService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DefaultCabMatchingStrategy implements CabMatchingStrategy{
    @Override
    public Cab getCab(CabService cabService, TripService tripService, Location riderLocation) {
        //for each cab, calculate the distance from rider
        //check if it is less than the max distance
        List<Pair<Double, Cab>> allMatchingCabs = new ArrayList<>();
        for(Cab cab : cabService.getAllCabsWhichHaveDriver()){
            if(cabService.isCabAvailable(cab)){
                double dist = getDist(riderLocation, cab.getCurrentLocation());
                if(dist <= CONSTANTS.MAX_DISTANCE){
                    allMatchingCabs.add(new Pair<>(dist, cab));
                }
            }
        }

        allMatchingCabs.sort(new Comparator<Pair<Double, Cab>>() {
            @Override
            public int compare(Pair<Double, Cab> o1, Pair<Double, Cab> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });

        return allMatchingCabs.getFirst().getVal();
    }

    private double getDist(Location riderLocation, Location cabLocation) {
        int x = Math.abs(riderLocation.getX()- cabLocation.getX());
        int y = Math.abs(riderLocation.getY()- cabLocation.getY());

        return Math.sqrt(Math.abs(x*x-y*y));
    }


}
