package caseStudies.carRental.services;

import caseStudies.carRental.model.PaymentStrategy.CashPaymentStrategy;
import caseStudies.carRental.model.PaymentStrategy.CreditPaymentStrategy;
import caseStudies.carRental.model.PaymentStrategy.PaymentStrategy;

import java.util.Locale;

public class PaymentService {
    PaymentStrategy paymentStrategy;

    PaymentService(){
        paymentStrategy = new CashPaymentStrategy();//default
    }

    public void setDefaultPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public PaymentStrategy getDefaultPaymentStrategy() {
        return paymentStrategy;
    }

    private PaymentStrategy getPaymentStrategy(String paymentType) {
        return switch (paymentType.toLowerCase()) {
            case "cash" -> new CashPaymentStrategy();
            case "card" -> new CreditPaymentStrategy();
            default -> this.paymentStrategy;
        };
    }

    public void processPayment(int amount, String paymentType){
        PaymentStrategy paymentStrategy1 = getPaymentStrategy(paymentType);
        paymentStrategy1.processPayment(amount);
    }


}
