package caseStudies.parkingLot2.models;

import caseStudies.parkingLot2.models.paymentStrategy.CardPaymentStrategy;
import caseStudies.parkingLot2.models.paymentStrategy.PaymentStrategy;
import caseStudies.parkingLot2.services.ParkingLotService;

public class CustomerInfoPortal {
    private final int infoPortalId;
    private final ParkingLotService parkingLotService;
    private final PaymentStrategy paymentStrategy;

    CustomerInfoPortal(int id, ParkingLotService lotService){
        this.infoPortalId = id;
        this.parkingLotService = lotService;
        this.paymentStrategy = new CardPaymentStrategy();
    }

    public void payForTicket(Ticket ticket){
//        parkingLotService.unpark(ticket, -1, paymentStrategy);//cant call this since it has other methods also like vacate spot etc.
        parkingLotService.payForTicket(ticket, paymentStrategy);
    }

    public int getInfoPortalId(){
        return this.infoPortalId;
    }
}
