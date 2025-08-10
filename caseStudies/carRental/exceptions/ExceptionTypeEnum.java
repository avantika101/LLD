package caseStudies.carRental.exceptions;

public enum ExceptionTypeEnum {
    VehicleUnavailable("Vehicle is not avaialble!"),
    VehicleAlreadyBooked("Vehicle is already booked");

    private String message;

    public String getMessage() {
        return message;
    }

    private ExceptionTypeEnum(String msg){
        this.message = msg;
    }
}
