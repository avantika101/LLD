package caseStudies.carRental.services;

import caseStudies.carRental.enums.NotificationType;
import caseStudies.carRental.enums.VehicleEvent;
import caseStudies.carRental.exceptions.ExceptionTypeEnum;
import caseStudies.carRental.exceptions.VehicleUnavailable;
import caseStudies.carRental.model.AddOns.Insurance.Insurance;
import caseStudies.carRental.model.AvailableVehicleStrategy.AvailableVehicleStrategy;
import caseStudies.carRental.model.AvailableVehicleStrategy.DefaultAvailableVehicleStrategy;
import caseStudies.carRental.model.Bookings;
import caseStudies.carRental.model.User;
import caseStudies.carRental.model.Vehicle;
import caseStudies.carRental.scheduler.NotificationScheduler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CarRentalService {

    BookingService bookingService;
    AvailableVehicleStrategy availableVehicleStrategy;
    VehicleInventory vehicleInventory;
    PaymentService paymentService;
    PricingService pricingService;
    NotificationService notificationService;
    NotificationScheduler notificationScheduler;
    VehicleLogService vehicleLogService;

    public CarRentalService(VehicleInventory vehicleInventory){
        this.bookingService = new BookingService();
        this.availableVehicleStrategy = new DefaultAvailableVehicleStrategy();
        this.vehicleInventory = vehicleInventory;
        this.paymentService = new PaymentService();
        this.pricingService = new PricingService();
        this.notificationService = new NotificationService();
        this.vehicleLogService = new VehicleLogService();
        manageNotificationScheduler();
    }

    private void manageNotificationScheduler() {
        this.notificationScheduler = new NotificationScheduler(notificationService, bookingService);
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

        // Run scheduler every hour
        executor.scheduleAtFixedRate(() -> {
            try {
                notificationScheduler.checkIn();
                notificationScheduler.checkOut();
            } catch (Exception e) {
                System.err.println("Error while running scheduler: " + e.getMessage());
            }
        }, 0, 5, TimeUnit.SECONDS);
    }

    public Set<Vehicle> getVehiclesBookedByUser(User user){
        return bookingService.getBookingForAUser(user);
    }

    public User findUserWhoBookedAVehicle(Vehicle veh){
        return bookingService.getBookingForAVehicle(veh);
    }

    public Bookings book(User user, Vehicle veh, LocalDateTime checkInDateTime, LocalDateTime checkOutDateTime){
        Bookings booking =  bookingService.makeBooking(user, checkInDateTime, checkOutDateTime, veh);
        notificationService.notify(booking, user, NotificationType.BOOKING_CONFIRMED);
        vehicleLogService.logEvent(veh.getNumberPlate(), VehicleEvent.BOOKED, "vehicle booked");
//        Bookings booking = null;
//        if(booking == null){
////            throw new RuntimeException(ExceptionTypeEnum.VehicleAlreadyBooked.getMessage());
////            throw new VehicleUnavailable();
//        }
        return booking;
    }

    public List<Vehicle> getAvailableVehicles(){
        return availableVehicleStrategy.getAvailableVehicles(vehicleInventory.getAllVehicles(), bookingService.getActiveBookings());
    }

    public void completeBooking(User user, Bookings bookings, String paymentMethod){
        bookingService.completeBooking(bookings);
        int fee = pricingService.getFee(bookings);
        paymentService.processPayment(fee, paymentMethod);
        notificationService.notify(bookings, user, NotificationType.BOOKING_COMPLETED);
    }

    public void cancelBooking(Bookings bookings){
        bookingService.cancelBooking(bookings);
    }

    public void buyInsurance(Bookings bookings, List<Insurance> ins){
        bookingService.buyInsurance(bookings, ins);//one & many configuration?
    }

    public List<Vehicle> getVehicleList(){
        return this.vehicleInventory.getAllVehicles();
    }

}
