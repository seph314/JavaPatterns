/*
* This program is created by Anders Pettersson as a seminar task in the course
* Object oriented design (IV1350) at KTH University.
*/
package inspection.controller;

import inspection.integration.CardTerminal;
import inspection.model.*;
import se.kth.iv1350.garage.Garage;
import inspection.integration.DatabaseManager;
import inspection.integration.InspectionTask;
import se.kth.iv1350.payauth.CreditCard;

import java.time.YearMonth;
import java.util.List;

/**
 * Created by Anders on 2017-04-24.
 * This is the application's single controller. All calls to the model pass through here.
 */
public class Controller {

    private Garage garage = new Garage();
    private DatabaseManager dbMgr;
    private Inspection inspection;
    private Vehicle vehicle;

    public Controller(DatabaseManager dbMgr) {
        this.dbMgr = dbMgr;
    }

    /**
     * Open door and update display
     */
    public void nextCustomer() {
        garage.nextCustomer();
    }

    /**
     * Close door
     */
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
        vehicle = new Vehicle(regNo);
        List<InspectionTask> inspectionProtocol = dbMgr.findInspectionByVehicle(vehicle);
        inspection = new Inspection(vehicle, inspectionProtocol);
        return inspection.getInspectionCost();
    }

    /**
     * Returns a inspectionProtocol list of inspections
     * @return
     */
    public List<InspectionTask> startInspection(){
        return inspection.performInspection();
    }

    /**
     * Pay with card
     */
    public String payWithCard(int pin, String number, String holder, YearMonth expiryDate, int CVC, double cost, double payedAmount) {
        CreditCard creditCard = new CreditCard(pin, number, holder, expiryDate, CVC);
        Amount amount = new Amount(cost, payedAmount);
        Receipt receipt = new Receipt(amount, vehicle);
        CardTerminal cardTerminal = new CardTerminal();
        return cardTerminal.newCardPayment(creditCard, amount, receipt);
    }
}
