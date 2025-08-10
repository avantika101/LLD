package caseStudies.parkingLot2.models;

import caseStudies.parkingLot2.models.paymentStrategy.PaymentStrategy;
import caseStudies.parkingLot2.models.pricingStrategy.PricingStrategy;

public interface Chargeable {
    public void charge();
    public void payForCharging(PaymentStrategy paymentStrategy, PricingStrategy pricingStrategy);
}
