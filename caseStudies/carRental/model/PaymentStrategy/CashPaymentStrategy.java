package caseStudies.carRental.model.PaymentStrategy;

import caseStudies.carRental.enums.PaymentMethod;

public class CashPaymentStrategy implements PaymentStrategy{
    @Override
    public void processPayment(int amount) {
        System.out.println("paid amount "+amount+" by CASH");
    }
}
