package caseStudies.carRental.exceptions;

public class VehicleUnavailable extends RuntimeException{
    public VehicleUnavailable(){
        super(ExceptionTypeEnum.VehicleUnavailable.getMessage());
    }
}
