package caseStudies.carRental.model.AvailableVehicleStrategy;

import caseStudies.carRental.model.Bookings;
import caseStudies.carRental.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class DefaultAvailableVehicleStrategy implements AvailableVehicleStrategy{
    @Override
    public List<Vehicle> getAvailableVehicles(List<Vehicle> allVehicles, List<Bookings> allBookings) {
        List<Vehicle> list = new ArrayList<>();

        //return all the vehicles which are not booked

        for(Vehicle vehicle : allVehicles){
            boolean isBooked = false;
            for(Bookings bookings : allBookings){
                if(bookings.getVehicle().equals(vehicle)){
                    isBooked = true;
                    break;
                }
            }
            if(!isBooked){
                list.add(vehicle);
            }
        }

        return list;
    }
}
