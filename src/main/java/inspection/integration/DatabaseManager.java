/*
* This program is created by Anders Pettersson as a seminar task in the course
* Object oriented design (IV1350) at KTH University.
*/
package inspection.integration;

import inspection.model.InspectionProtocol;
import inspection.model.InspectionTask;
import inspection.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anders on 2017-04-25.
 * The database manager emulates the function of a real database in this program
 */
public class DatabaseManager {

    private ArrayList<Vehicle> scheduledVehicles = new ArrayList<>();

    /**
     * The constructor creates all vehicles scheduled for inspections
     */
    public DatabaseManager() {

        scheduledVehicles.add(new Vehicle("ABC123"));
        scheduledVehicles.add(new Vehicle("IKL123"));
        scheduledVehicles.add(new Vehicle("MDF345"));
        scheduledVehicles.add(new Vehicle("QQQ332"));
    }

    /**
     * Checks if the regnumber entered matches a regnumber in the database.
     * If it does, it returns an inspectionProtocol in the form of a list
     *
     * @param vehicle
     * @return
     */
    public List<InspectionTask> findInspectionByVehicle(Vehicle vehicle) throws IllegalLicenseNumberException {

        if (vehicle == null) {
            throw new IllegalStateException("Please enter a registrationnumer (ABC123,IKL123,MDF345 or QQQ332).");
        }

        if (!scheduledVehicles.contains(vehicle))
            throw new IllegalLicenseNumberException(vehicle);

        InspectionProtocol inspectionProtocol = new InspectionProtocol();
        return inspectionProtocol.createDummyInspections();
    }
}
