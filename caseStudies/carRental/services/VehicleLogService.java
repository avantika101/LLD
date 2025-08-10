package caseStudies.carRental.services;

import caseStudies.carRental.enums.VehicleEvent;
import caseStudies.carRental.model.Vehicle;
import caseStudies.carRental.model.VehicleLog;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class VehicleLogService {
    List<VehicleLog> vehicleLogs;

    VehicleLogService(){
        this.vehicleLogs = new ArrayList<>();
    }

    public void logEvent(String vehicleId, VehicleEvent type, String description){
        VehicleLog log = new VehicleLog(vehicleId, type, description);
        vehicleLogs.add(log);
        System.out.println("log added");
    }

    public List<VehicleLog> getLogsForVehicle(Vehicle vehicle){
        List<VehicleLog> list = new ArrayList<>();

        for(VehicleLog log : vehicleLogs){
            if(log.getVehicleId().equals(vehicle.getNumberPlate())){
                list.add(log);
            }
        }

        return list;
    }
}
