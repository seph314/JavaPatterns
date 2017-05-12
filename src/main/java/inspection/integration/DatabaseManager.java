/*
* This program is created by Anders Pettersson as a seminar task in the course
* Object oriented design (IV1350) at KTH University.
*/
package inspection.integration;

import inspection.model.Vehicle;
import java.util.List;

/**
 * Created by Anders on 2017-04-25.
 * The database manager emulates the function of a real database in this program
 */
public class DatabaseManager {

    /**
     * @param scheduledVehicle symbolizes a vehicle in the database
     */
    private Vehicle scheduledVehicle = new Vehicle("ABC123");

    /**
     * Checks if the regnumber entered matches a regnumber in the database.
     * If it does, it returns an inspectionProtocol in the form of a list
     * @param vehicle
     * @return
     */
    public List<InspectionTask> findInspectionByVehicle(Vehicle vehicle) throws IllegalLicenseNumberException{
        if (vehicle == null) {
            throw new IllegalStateException("Please enter a registrationnumer (ABC123).");
        }

        if (!scheduledVehicle.getRegNo().equalsIgnoreCase(vehicle.getRegNo())){
            throw new IllegalLicenseNumberException(vehicle);
        }

        InspectionProtocol inspectionProtocol = new InspectionProtocol();
        return inspectionProtocol.createDummyInspections();

//        if (scheduledVehicle.getRegNo().equals(vehicle.getRegNo())){
//            InspectionProtocol inspectionProtocol = new InspectionProtocol();
//            return inspectionProtocol.createDummyInspections();
//        }
//        else{
//            return null;
//        }
    }
}
