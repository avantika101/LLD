package caseStudies.parkingLot;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ParkingLot {

    List<ParkingFloor> floors ;
    List<Ticket> activeTicket ;

    /**
     * can have different constructors for it.
     * 1. can take both nFloors and nSpots each floor
     * 2. ??
     */
    public ParkingLot(int floors,  Map<SpotType, Integer> spotConfig){
        this.activeTicket = new ArrayList<>();
        this.floors = new ArrayList<>();

        for(int i = 0; i < floors ; i++){
            this.floors.add(new ParkingFloor(spotConfig));
        }

    }

//    public void addFloor(){
//        //assume that we always add new floor nums only
//        floors.add(new ParkingFloor(spots, Map<SpotType, Integer> spotConfig));
//    }

    public ParkingSpot assignSpot(VehicleType vt){
        for(ParkingFloor floor : floors){
            ParkingSpot availableSpot = floor.getAvailableSpot(vt);
            if(availableSpot != null){
                availableSpot.occupy();
                System.out.println("available spot found : "+availableSpot.getNum() + ",floor:" + floor.getFloorNum());
                return availableSpot;
            }
        }

        return null;
    }

    public void markActive(Ticket tc){
        this.activeTicket.add(tc);
    }

    public void markInActive(Ticket tc){
        this.activeTicket.remove(tc);
    }


    public Ticket park(Vehicle veh){

        for(ParkingFloor floor : floors){
            ParkingSpot availableSpot = floor.getAvailableSpot(veh.getType());
            if(availableSpot != null){
                availableSpot.occupy();
                Ticket ticket = new Ticket(availableSpot, veh.getNumberPlate());
                activeTicket.add(ticket);
                System.out.println("available spot found : "+availableSpot.getNum() + ",floor:" + floor.getFloorNum());
                System.out.println("generated ticket id:"+ticket.getId());
                return ticket;
            }
        }

        return null;
    }

    public double unpark(Ticket ticket){//during unpark, we'll need a ticket
        //can it be done via vehicle?
        if(activeTicket.contains(ticket)){
            ticket.markExit(new Date());
            double fee = ticket.calculateFee();
            ticket.getSpot().vacate();// wrong way of calling due to tight coupling
            this.activeTicket.remove(ticket);
            System.out.println("vehicle unparked : "+ticket.getVehicleNumber());
            return fee;
        }

        System.out.println("invalid ticket for vehicle : "+ticket.getVehicleNumber());
        return 0;
    }


    public void releaseSpot(Ticket tc) {
        tc.markExit(new Date());
    }

    public void showAvailableSpots(){
        System.out.println("============= available spots ================");

        for(ParkingFloor floor : floors){
            floor.showAvailableSpots();
        }

        System.out.println("============ end of msg =================");

    }
}
