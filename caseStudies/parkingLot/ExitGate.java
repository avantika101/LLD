package caseStudies.parkingLot;

import java.time.LocalDate;
import java.util.Date;

public class ExitGate {
    private final int gateId;
    private final ParkingLot lot;
    private final PaymentService paymentService;

    public ExitGate(int i, ParkingLot lot, PaymentService ps) {
        this.gateId = i;
        this.lot = lot;
        this.paymentService = ps;
    }

//    public int exitLot(Ticket tc){
//        return this.lot.unpark(tc);
//    }

    public void processPaymentAndExit(Ticket tc, PaymentMethod method){
        if(tc.isPaid()) {
            System.out.println("ticket already paid!");
        }else{
            lot.releaseSpot(tc);
            lot.markInActive(tc);
            tc.markExit(new Date());
            paymentService.processPayment(tc, method);
        }
    }
}
