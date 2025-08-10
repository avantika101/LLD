package caseStudies.parkingLot2.models;

import caseStudies.parkingLot.SpotType;
import caseStudies.parkingLot2.models.paymentStrategy.PaymentStrategy;
import caseStudies.parkingLot2.models.pricingStrategy.PricingStrategy;

import java.time.Duration;

public class ElectricSpot extends ParkingSpot implements Chargeable{
    public ElectricSpot(int num, SpotType spotType) {
        super(num, spotType);
    }

    @Override
    public void charge() {
        System.out.println("charging electric car!");
    }

    @Override
    public void payForCharging(PaymentStrategy paymentStrategy, PricingStrategy pricingStrategy) {
        int fee = pricingStrategy.calculateFee(Duration.ofMinutes(60));
        paymentStrategy.pay(fee);
        System.out.println("paid fee for charging : "+fee);
    }
}
