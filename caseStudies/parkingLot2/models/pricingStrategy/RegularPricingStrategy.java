package caseStudies.parkingLot2.models.pricingStrategy;

import java.time.Duration;

public class RegularPricingStrategy implements PricingStrategy{
    @Override
    public int calculateFee(Duration duration) {
        return (int) (duration.toMinutes()*1.0);
    }
}
