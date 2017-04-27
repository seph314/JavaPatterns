package inspection.integration;

import inspection.model.Vehicle;

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

//        Spårutskrift
//        System.out.println(vehicle.getRegNo());
        if (scheduledVehicle.getRegNo().equals(vehicle.getRegNo())){
            InspectionProtocol inspectionProtocol = new InspectionProtocol();
            return inspectionProtocol.createDummyInspections();
        }
        else{
            return null;
        }
    }
}
