package caseStudies.parkingLot2.models.pricingStrategy;

import java.time.Duration;

public interface PricingStrategy {
    public int calculateFee(Duration duration);
}
