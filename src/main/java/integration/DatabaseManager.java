package main.java.integration;

import main.java.model.InspectionProtocol;
import main.java.model.Vehicle;

/**
 * Created by Anders on 2017-04-25.
 */
public class DatabaseManager {

    /**
     * @param scheduledVehicle symbolizes a vehicle in the database
     * @param scheduledVehiclesInspectionProtocol symbolizes a inspection protocol for that vehicle
     */
    private Vehicle scheduledVehicle = new Vehicle("ABC123");
    private InspectionProtocol scheduledVehiclesInspectionProtocol = new InspectionProtocol();

    public InspectionProtocol findInspectionByVehicle(Vehicle vehicle){
        if (scheduledVehicle.equals(vehicle))
            return scheduledVehiclesInspectionProtocol;
        else
            return null;
    }
}
