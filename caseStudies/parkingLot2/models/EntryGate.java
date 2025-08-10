package caseStudies.parkingLot2.models;

import caseStudies.parkingLot2.services.ParkingLotService;

public class EntryGate {
    private final int gateId;
    private ParkingLotService parkingLotService;

    EntryGate(int id, ParkingLotService parkingLotService){
        this.gateId = id;
        this.parkingLotService = parkingLotService;
    }

    public Ticket issueTicket(Vehicle veh){
        return parkingLotService.park(veh, gateId);
    }

    public int getGateId(){
        return this.gateId;
    }
}
