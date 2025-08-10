package caseStudies.carRental.model.PaymentStrategy;

import caseStudies.carRental.enums.PaymentMethod;

public interface PaymentStrategy {
    public void processPayment(int amount);
}
