package caseStudies.carRental.model.AvailableVehicleStrategy;

import caseStudies.carRental.model.Bookings;
import caseStudies.carRental.model.Vehicle;

import java.util.List;

public interface AvailableVehicleStrategy {
    public List<Vehicle> getAvailableVehicles(List<Vehicle> allVehicles, List<Bookings> allBookings);
}
