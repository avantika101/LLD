package caseStudies.carRental.services;

import caseStudies.carRental.model.Bookings;
import caseStudies.carRental.model.PricingStrategy.DefaultPricingStrategy;
import caseStudies.carRental.model.PricingStrategy.PricingStrategy;

public class PricingService {
    PricingStrategy pricingStrategy;

    PricingService(){
        this.pricingStrategy = new DefaultPricingStrategy();
    }

    public PricingStrategy getDefaultPricingStrategy() {
        return pricingStrategy;
    }

    public void setDefaultPricingStrategy(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public int getFee(Bookings bookings){
        return pricingStrategy.calculateFee(bookings);
    }

}
