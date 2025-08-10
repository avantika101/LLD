package caseStudies.parkingLot;

public class ParkingSpot {

    private static int counter = 0;
    private boolean isOcc;
    private final int num;
    private final SpotType type;
    private final ElectricPanel electricPanel;

    ParkingSpot(SpotType type){
        this.num = ++ParkingSpot.counter;
        this.type = type;
        this.electricPanel = type.equals(SpotType.ELECTRIC) ? new ElectricPanel() : null;
    }

    public int getNum() {
        return num;
    }

    public boolean isAvailable() {
        return !isOcc;
    }

    public void occupy() {
        this.isOcc = true;
    }

    public void vacate() {
        this.isOcc = false;
    }

    public SpotType getType() { return this.type; }

    public boolean hasElectricPanel() { return this.electricPanel != null; }

    public ElectricPanel getElectricPanel() {
        return electricPanel;
    }

}
