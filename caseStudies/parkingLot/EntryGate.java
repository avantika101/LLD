package caseStudies.parkingLot;

public class EntryGate {
    private final int gateId;
    private ParkingLot lot;
    private DisplayBoard displayBoard;

    EntryGate(int id, ParkingLot lot){
        this.gateId = id;
        this.lot = lot;
        this.displayBoard = new DisplayBoard(0);
    }

    public Ticket issueTicket(Vehicle veh){

        ParkingSpot availableSpot = lot.assignSpot(veh.getType());
        if(availableSpot != null){
            Ticket ticket = new Ticket(availableSpot, veh.getNumberPlate());
            lot.markActive(ticket);
            System.out.println("generated ticket id:"+ticket.getId());
            return ticket;
        }

        displayBoard.showFullMessage("[DisplayBoard] Parking Full - Please try later");

        System.out.println("parking unavailable!");
        return null;
    }

//violates srp since lot does everything
//    public Ticket issueTicket(Vehicle veh){
//        return this.lot.park(veh);
//    }
}
