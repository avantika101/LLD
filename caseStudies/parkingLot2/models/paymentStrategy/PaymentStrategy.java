package caseStudies.parkingLot2.models.paymentStrategy;

import caseStudies.parkingLot2.enums.PaymentMethod;

public interface PaymentStrategy {
    public void pay(int fee);
}
