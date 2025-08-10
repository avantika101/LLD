package caseStudies.parkingLot;

import java.util.HashMap;
import java.util.Map;

public class Application {
    public static void main(String args[]) throws InterruptedException {
        Map<SpotType, Integer> spotConfig = new HashMap<>();
        spotConfig.put(SpotType.MOTORCYCLE, 2);
        spotConfig.put(SpotType.COMPACT, 2);
        spotConfig.put(SpotType.LARGE, 1);

        ParkingLot parkingLot = new ParkingLot(2,spotConfig);

        parkingLot.showAvailableSpots();

        Vehicle car = new Vehicle("AH1234", VehicleType.CAR);
        Vehicle scooter = new Vehicle("KL5678", VehicleType.BIKE);
        Vehicle bike = new Vehicle("AZ9078", VehicleType.BIKE);

//        Ticket tc = parkingLot.park(car);
//        Ticket ts = parkingLot.park(scooter);
//        Ticket tb = parkingLot.park(bike);
//        parkingLot.unpark(tc);

        /**
         * after adding entry and exit points.
         * assume there is only one entry and one exit point in the entire lot
         */

        PaymentService ps = new PaymentService();
        EntryGate entry = new EntryGate(1, parkingLot);
        ExitGate exit = new ExitGate(2, parkingLot, ps);

        Ticket carTicket = entry.issueTicket(car);
        Thread.sleep(2000);
        exit.processPaymentAndExit(carTicket, PaymentMethod.CARD);

    }
}
