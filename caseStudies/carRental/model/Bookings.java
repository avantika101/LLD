package caseStudies.carRental.model;

import caseStudies.carRental.enums.BookingStatus;
import caseStudies.carRental.enums.NotificationType;
import caseStudies.carRental.model.AddOns.Insurance.Insurance;

import java.time.LocalDateTime;
import java.util.*;

public class Bookings {
    private final UUID bookingId;
    private final User bookedBy;
    private final LocalDateTime bookedOn;
    private final LocalDateTime checkInDateTime;
    private final LocalDateTime checkOutDateTime;
    private LocalDateTime completedOn;
    private final Vehicle vehicle;
    private BookingStatus bookingStatus;
    private Set<NotificationType> notificationTypeSet;
    private List<Insurance> insuranceList;


    public Bookings(UUID bookingId, User bookedBy, LocalDateTime bookedOn, LocalDateTime checkInDateTime, LocalDateTime checkOutDateTime, Vehicle vehicle) {
        this.bookingId = bookingId;
        this.bookedBy = bookedBy;
        this.bookedOn = bookedOn;
        this.checkInDateTime = checkInDateTime;
        this.checkOutDateTime = checkOutDateTime;
        this.vehicle = vehicle;
        this.bookingStatus = BookingStatus.ACTIVE;
        this.notificationTypeSet = new HashSet<>();
        this.insuranceList = new ArrayList<>();
    }

    public UUID getBookingId() {
        return bookingId;
    }

    public User getBookedBy() {
        return bookedBy;
    }

    public LocalDateTime getBookedOn() {
        return bookedOn;
    }

    public LocalDateTime getCheckInDateTime() {
        return checkInDateTime;
    }

    public LocalDateTime getCheckOutDateTime() {
        return checkOutDateTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public boolean isBookingActive(){
        return this.bookingStatus.equals(BookingStatus.ACTIVE);
    }

    public void cancelBooking(){
        this.bookingStatus = BookingStatus.CANCELED;
    }

    public void completeBooking(){
        this.bookingStatus = BookingStatus.COMPLETED;
    }

    public LocalDateTime getCompletedOn() {
        return completedOn;
    }

    public void setCompletedOn(LocalDateTime completedOn) {
        this.completedOn = completedOn;
    }

    public boolean doesNotificationTypeExist(NotificationType notificationType) {
        return notificationTypeSet.contains(notificationType);
    }

    public void addNotificationTypeInSet(NotificationType notificationType){
        notificationTypeSet.add(notificationType);
    }

    public List<Insurance> getInsuranceList() {
        return insuranceList;
    }

    public void addInsurance(Insurance insurance) {
        insuranceList.add(insurance);
    }

    public boolean checkIfInsurancePresent(Insurance insurance){
        return insuranceList.contains(insurance);
    }
}
