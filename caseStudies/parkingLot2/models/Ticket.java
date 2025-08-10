package caseStudies.parkingLot2.models;

import caseStudies.parkingLot2.enums.TicketStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Ticket {
    private final String ticketId;
    private final ParkingSpot spot;
    private final Vehicle veh;
    private TicketStatus ticketStatus;
    private final LocalDateTime createdAt;
    private final int entryGateId;
    private int exitGateId;

    public Ticket(String id, ParkingSpot spot, Vehicle veh, int entryGateId){
        this.ticketId = id;
        this.spot = spot;
        this.veh = veh;
        ticketStatus = TicketStatus.ACTIVE;
        this.createdAt = LocalDateTime.now();
        this.entryGateId = entryGateId;
    }

    public String getTicketId() {
        return ticketId;
    }

    public ParkingSpot getSpot() {
        return spot;
    }

    public Vehicle getVeh() {
        return veh;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public void markPaid(){
        this.ticketStatus = TicketStatus.PAID;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public int getEntryGateId(){
        return this.entryGateId;
    }

    public void setExitGateId(int exitGateId){
        this.exitGateId = exitGateId;
    }

    public int getExitGateId(){
        return this.exitGateId;
    }

    public boolean isPaid() {
        return this.ticketStatus.equals(TicketStatus.PAID);
    }
}
