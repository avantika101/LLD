package caseStudies.carRental.model.NotificationStrategy;

import caseStudies.carRental.model.Bookings;

public interface NotificationStrategy {
    public void sendNotification(Bookings booking);
}
