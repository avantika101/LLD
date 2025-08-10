package caseStudies.carRental.scheduler;

import caseStudies.carRental.enums.NotificationType;
import caseStudies.carRental.model.Bookings;
import caseStudies.carRental.services.BookingService;
import caseStudies.carRental.services.NotificationService;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class NotificationScheduler {

    NotificationService notificationService;
    BookingService bookingService;

    public NotificationScheduler(NotificationService notificationService, BookingService bookingService){
        this.notificationService = notificationService;
        this.bookingService = bookingService;
    }

    public void checkIn() {
        List<Bookings> allBookings = bookingService.getActiveBookings();

        for (Bookings booking : allBookings) {
            // schedule and send notifications here
            if(booking.isBookingActive()){
                long hoursToCheckIn = ChronoUnit.HOURS.between(LocalDateTime.now(), booking.getCheckInDateTime());
                if(!booking.doesNotificationTypeExist(NotificationType.BEFORE_CHECKIN)){//hoursToCheckIn <= 24 && hoursToCheckIn > 0 &&
                    notificationService.notify(booking, booking.getBookedBy(), NotificationType.BEFORE_CHECKIN);
                    booking.addNotificationTypeInSet(NotificationType.BEFORE_CHECKIN);
                }
            }
        }
    }

    public void checkOut() {
        List<Bookings> allBookings = bookingService.getActiveBookings();

        for (Bookings booking : allBookings) {
            // schedule and send notifications here
            if(booking.isBookingActive()){
                long hoursToCheckIn = ChronoUnit.HOURS.between(LocalDateTime.now(), booking.getCheckOutDateTime());
                if(hoursToCheckIn <= 24 && hoursToCheckIn > 0 && !booking.doesNotificationTypeExist(NotificationType.BEFORE_CHECKOUT)){
                    notificationService.notify(booking, booking.getBookedBy(), NotificationType.BEFORE_CHECKOUT);
                    booking.addNotificationTypeInSet(NotificationType.BEFORE_CHECKOUT);
                }
            }
        }
    }


}
