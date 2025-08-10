package caseStudies.parkingLot2.models.paymentStrategy;

public class CashPaymentStrategy implements PaymentStrategy{
    @Override
    public void pay(int fee) {
        System.out.println("pay by cash!");
    }
}
