package caseStudies.carRental.model.NotificationStrategy;

import caseStudies.carRental.model.Bookings;

public class SMSNotificationStrategy implements NotificationStrategy{
    @Override
    public void sendNotification(Bookings booking) {
        System.out.println("notifying user "+booking.getBookedBy().getUserId()+" for booking "+booking.getBookingId()+" by sms.");
    }
}
