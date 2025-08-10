package caseStudies.carRental.services;

import caseStudies.carRental.model.AddOns.Insurance.Insurance;
import caseStudies.carRental.model.Bookings;
import caseStudies.carRental.model.User;
import caseStudies.carRental.model.Vehicle;

import java.time.LocalDateTime;
import java.util.*;

public class BookingService {
    List<Bookings> activeBookings;

    BookingService(){
        this.activeBookings = new ArrayList<>();
    }

    public List<Bookings> getActiveBookings() {
        return activeBookings;
    }

    public Bookings makeBooking(User user, LocalDateTime checkIn, LocalDateTime checkOut, Vehicle veh){
        Bookings booking = new Bookings(UUID.randomUUID(), user, LocalDateTime.now(), checkIn, checkOut, veh );
        activeBookings.add(booking);
        return booking;
    }

    public void cancelBooking(Bookings bookings){
        bookings.cancelBooking();
        bookings.setCompletedOn(LocalDateTime.now());
        activeBookings.remove(bookings);
    }

    public void completeBooking(Bookings bookings){
        bookings.completeBooking();
        bookings.setCompletedOn(LocalDateTime.now());
        activeBookings.remove(bookings);
    }

    public Set<Vehicle> getBookingForAUser(User user){
        Set<Vehicle> list = new HashSet<>();

        for(Bookings bookings : activeBookings){
            if(bookings.getBookedBy().equals(user)){
                list.add(bookings.getVehicle());
            }
        }

        return list;
    }

    public User getBookingForAVehicle(Vehicle vehicle){
        for(Bookings bookings : activeBookings){
            if(bookings.getVehicle().equals(vehicle)){
                return bookings.getBookedBy();
            }
        }
        return null;
    }

    public void buyInsurance(Bookings bookings, List<Insurance> list){
        for(Insurance ins : list){
            bookings.addInsurance(ins);
        }
    }

    public void buyInsurance(Bookings bookings, Insurance ins){
        bookings.addInsurance(ins);
    }

}
