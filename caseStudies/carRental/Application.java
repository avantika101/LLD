package caseStudies.carRental;

import caseStudies.carRental.enums.UserType;
import caseStudies.carRental.enums.VehicleType;
import caseStudies.carRental.model.Bookings;
import caseStudies.carRental.model.User;
import caseStudies.carRental.model.Vehicle;
import caseStudies.carRental.services.CarRentalService;
import caseStudies.carRental.services.VehicleInventory;

import java.time.LocalDateTime;
import java.util.List;

public class Application {
    public static void main(String args[]){
        VehicleInventory vehicleInventory = new VehicleInventory();
        Vehicle car = new Vehicle("car123", VehicleType.car);
        Vehicle bike = new Vehicle("bike123", VehicleType.motorcycle);
        vehicleInventory.addVehicle(car);
        vehicleInventory.addVehicle(bike);

        User user1 = new User(1, UserType.USER);
        User user2 = new User(2, UserType.USER);

        CarRentalService service = new CarRentalService(vehicleInventory);

        List<Vehicle> availableVehicles = service.getAvailableVehicles();
        for(Vehicle veh : availableVehicles){
            System.out.println(veh.getNumberPlate());
        }

        Bookings bookingId = service.book(user1, car, LocalDateTime.of(2025, 8, 15, 10, 0), LocalDateTime.of(2025, 8, 16, 10, 0));
        System.out.println("bookedBy:"+bookingId.getBookedBy().getUserId());

        System.out.println("after booking");
        availableVehicles = service.getAvailableVehicles();
        for(Vehicle veh : availableVehicles){
            System.out.println(veh.getNumberPlate());
        }
//        Vehicle bike2 = new Vehicle("bike123", VehicleType.motorcycle);
//        vehicleInventory.addVehicle(bike2);
//        System.out.println(service.getVehicleList());





    }
}
