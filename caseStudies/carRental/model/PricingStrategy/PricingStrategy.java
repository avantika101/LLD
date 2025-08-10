package caseStudies.carRental.model.PricingStrategy;

import caseStudies.carRental.model.Bookings;

public interface PricingStrategy {
    public int calculateFee(Bookings bookings);
}
