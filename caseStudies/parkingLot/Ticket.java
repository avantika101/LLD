package caseStudies.parkingLot;

import java.time.LocalDate;
import java.util.Date;

public class Ticket {
    private static int counter = 0;
    private final int id;
    private final ParkingSpot spot;
    private final Date entryDate;
    private Date exitDate;
    private String vehicleNumber;
    private boolean isPaid;

    public int getId(){
        return this.id;
    }

    public ParkingSpot getSpot() {
        return spot;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public Date getExitDate() {
        return exitDate;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    Ticket(ParkingSpot spot, String veh){
        this.id = ++Ticket.counter;
        this.spot = spot;
        this.vehicleNumber = veh;
        this.entryDate = new Date();
        this.isPaid = false;
    }

    public void markExit(Date date) {
        this.exitDate = date;
        this.spot.vacate(); // wrong because why should ticket class handle all of this?
        this.isPaid = true;
    }

    public double calculateFee(){
        long durationMillis = exitDate.getTime() - entryDate.getTime();
        long hours = Math.max(1, durationMillis / (1000 * 60 * 60));
        return hours * 50.0;
    }

    public void markPaid(){
        this.isPaid = true;
    }

    public boolean isPaid(){
        return isPaid;
    }
}
