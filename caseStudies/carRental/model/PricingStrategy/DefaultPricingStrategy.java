package caseStudies.carRental.model.PricingStrategy;

import caseStudies.carRental.model.Bookings;

import java.time.LocalDateTime;

public class DefaultPricingStrategy implements PricingStrategy{
    @Override
    public int calculateFee(Bookings bookings) {
        int val = bookings.getCheckOutDateTime().compareTo(bookings.getCheckInDateTime())*2;//even
        if(bookings.getCheckOutDateTime().isBefore(LocalDateTime.now())){
            val += 1;//odd
        }
        return val;
    }
}
