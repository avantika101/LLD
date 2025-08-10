package caseStudies.carRental.model.PaymentStrategy;

public class CreditPaymentStrategy implements PaymentStrategy{
    @Override
    public void processPayment(int amount) {
        System.out.println("paid amount "+amount+" by CARD");
    }
}
