package main.java.integration;

import main.java.model.Vehicle;

import java.util.List;

/**
 * Created by Anders on 2017-04-25.
 */
public class DatabaseManager {

    /**
     * @param scheduledVehicle symbolizes a vehicle in the database
     * @param scheduledVehiclesInspectionProtocol symbolizes a inspection protocol for that vehicle
     */
    private Vehicle scheduledVehicle = new Vehicle("ABC123");

    public List<InspectionTask> findInspectionByVehicle(Vehicle vehicle){
        /**
         * Compares the entered regnumber with existing in "database"
         * men det funkar inte? varför...
         */
       System.out.println(vehicle.getRegNo());
        if (scheduledVehicle.getRegNo().equals(vehicle.getRegNo())){
            InspectionProtocol inspectionProtocol = new InspectionProtocol();
            return inspectionProtocol.createDummyInspections();
        }
        else{
            System.out.println("There is no booked inspection for this car");
            return null;
        }
    }
}
