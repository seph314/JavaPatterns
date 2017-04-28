package inspection.controller;

import se.kth.iv1350.garage.Garage;
import inspection.integration.DatabaseManager;
import inspection.integration.InspectionTask;
import inspection.model.Inspection;
import inspection.model.Vehicle;
import java.util.List;

/**
 * Created by Anders on 2017-04-24.
 * This is the application's single controller. All calls to the model pass through here.
 */
public class Controller {

    private Garage garage = new Garage();
    private DatabaseManager dbMgr;


    public Controller(DatabaseManager dbMgr) {
        this.dbMgr = dbMgr;
    }

    public void nextCustomer() {
        garage.nextCustomer();
    }

    public void closeDoor() {
        garage.closeDoor();
    }

    /**
     * Create vehicle
     * Search for matching inspection
     * Creates inspection with found protocol and vehicle
     *
     * @param regNo
     * @return returns the cost for the inspection
     */
    public double findInspection(String regNo) {
        Vehicle vehicle = new Vehicle(regNo);
        List<InspectionTask> inspectionProtocol = dbMgr.findInspectionByVehicle(vehicle);
        Inspection inspection = new Inspection(vehicle, inspectionProtocol);
        return inspection.getInspectionCost();
    }

    /**
     * Starts inspection
     * Uses the inspection created in findInspection
     */
    public void startInspection(){

    }
}
