package caseStudies.parkingLot2.models.paymentStrategy;

public class CardPaymentStrategy implements PaymentStrategy{
    @Override
    public void pay(int fee) {
        System.out.println("pay by card!");
    }
}
