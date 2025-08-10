package caseStudies.parkingLot2.services;

import caseStudies.parkingLot2.enums.PaymentMethod;
import caseStudies.parkingLot2.models.*;
import caseStudies.parkingLot2.models.pricingStrategy.PricingStrategy;
import caseStudies.parkingLot2.models.spotAllocationStrategy.SpotAllocationStrategy;
import caseStudies.parkingLot2.models.paymentStrategy.PaymentStrategy;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ParkingLotService {

    ParkingLot lot;
//    PaymentStrategy paymentStrategy;
    PricingStrategy pricingStrategy;
    SpotAllocationStrategy spotAllocationStrategy;

    Map<String, Ticket> activeTickets;

    public ParkingLotService(ParkingLot lot, PricingStrategy pricingStrategy, SpotAllocationStrategy spotAllocationStrategy){
        this.lot = lot;
        this.pricingStrategy = pricingStrategy;
//        this.paymentStrategy = paymentStrategy;
        this.spotAllocationStrategy = spotAllocationStrategy;
        this.activeTickets = new HashMap<>();
    }

    public Ticket park(Vehicle veh, int gateId){
        ParkingSpot availableSpot = spotAllocationStrategy.getAvailableParkingSpot(lot.getFloors());

        if(availableSpot.isAvailable()){
            availableSpot.occupy();
        }

        Ticket ticket = new Ticket(UUID.randomUUID().toString(), availableSpot, veh, gateId);
        activeTickets.put(ticket.getTicketId(), ticket);

        return ticket;

    }

    public void unpark(Ticket ticket, int gateId, PaymentStrategy paymentStrategy){

        ParkingSpot parkedSpot = ticket.getSpot();
        parkedSpot.vacate();

        try{
            if(!ticket.isPaid()){
                payForTicket(ticket, paymentStrategy);
            }
            ticket.setExitGateId(gateId);
            activeTickets.remove(ticket.getTicketId());
        }catch(Exception e){
            System.out.println("payment incomplete!");
        }

    }

    public void payForTicket(Ticket ticket, PaymentStrategy paymentStrategy){
        Duration duration = Duration.between(ticket.getCreatedAt(), LocalDateTime.now());
        int fee = pricingStrategy.calculateFee(duration);
        paymentStrategy.pay(fee);
        ticket.markPaid();
    }

}
