package caseStudies.parkingLot2.models;

import caseStudies.parkingLot2.enums.PaymentMethod;
import caseStudies.parkingLot2.models.paymentStrategy.PaymentStrategy;
import caseStudies.parkingLot2.services.ParkingLotService;

public class ExitGate {
    private final int gateId;
    private ParkingLotService parkingLotService;

    ExitGate(int id, ParkingLotService parkingLotService){
        this.gateId = id;
        this.parkingLotService = parkingLotService;
    }

    public void payTicket(Ticket ticket, PaymentStrategy paymentStrategy){
        parkingLotService.unpark(ticket, this.gateId, paymentStrategy);
    }

    public int getGateId(){
        return this.gateId;
    }
}
