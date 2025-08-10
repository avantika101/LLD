package caseStudies.parkingLot;

public class ChargingService {
    public void handleCharging(ParkingSpot spot, double amount, PaymentMethod method) {
        if (spot != null && spot.hasElectricPanel()) {
            ElectricPanel panel = spot.getElectricPanel();
            panel.chargeVehicle();
            panel.payForCharging(amount, method);
        } else {
            System.out.println("No electric panel found for this spot.");
        }
    }
}
