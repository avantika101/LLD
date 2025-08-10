package caseStudies.parkingLot;

public class ElectricPanel {
    public void chargeVehicle() {
        System.out.println("Charging in progress...");
    }

    public void payForCharging(double amount, PaymentMethod method) {
        System.out.println("Charging fee of ₹" + amount + " paid via " + method);
    }
}
