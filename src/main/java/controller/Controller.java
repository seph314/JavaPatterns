package main.java.controller;

import main.java.integration.DatabaseManager;
import main.java.model.Inspection;
import main.java.model.Vehicle;
import se.kth.iv1350.garage.Garage;


/**
 * Created by Anders on 2017-04-24.
 * This is the application's single controller. All calls to the model pass through here.
 */
public class Controller {

    Garage garage = new Garage();
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

    public double findInspection(String regNo) {
        Vehicle vehicle = new Vehicle(regNo);
        Inspection inspection = new Inspection(dbMgr.findInspectionByVehicle(vehicle));
        return inspection.getInspectionCost();

    }
}
