/*
* This program is created by Anders Pettersson as a seminar task in the course
* Object oriented design (IV1350) at KTH University.
*/
package inspection.controller;

import inspection.integration.CardTerminal;
import inspection.integration.IllegalLicenseNumberException;
import inspection.model.*;
import se.kth.iv1350.garage.Garage;
import inspection.integration.DatabaseManager;
import inspection.model.InspectionTask;
import se.kth.iv1350.payauth.CreditCard;

import java.time.YearMonth;
import java.util.ArrayList;
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
    private List<InspectionTaskObserver> inspectionTaskObservers = new ArrayList<>();

    /**
     * Controller constructor
     * @param dbMgr
     */
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
     * @param regNo is the registrationnumber of a Vehicle
     * @return returns the cost for the inspection
     */
    public double findInspection(String regNo) throws IllegalLicenseNumberException {
        vehicle = new Vehicle(regNo);
        List<InspectionTask> inspectionProtocol = null;
        inspectionProtocol = dbMgr.findInspectionByVehicle(vehicle);
        inspection = new Inspection(vehicle, inspectionProtocol);
        return inspection.getInspectionCost();

    }

    /**
     * Returns a inspectionProtocol list of inspections
     * @return
     */
    public List<InspectionTask> startInspection(){
        List<InspectionTask> inspectionTasks = inspection.performInspection();
        return inspectionTasks;
    }

    /**
     *  Pay with card created a credit card objekt, amount objekt, receipt and card terminal instance
     * @param pin
     * @param number
     * @param holder
     * @param expiryDate
     * @param CVC
     * @param cost
     * @param payedAmount
     * @return a receipt object of the payment
     */
    public String payWithCard(int pin, String number, String holder, YearMonth expiryDate, int CVC, double cost, double payedAmount) {
        CreditCard creditCard = new CreditCard(pin, number, holder, expiryDate, CVC);
        Amount amount = new Amount(cost, payedAmount);
        ReceiptBuilder rb = new ReceiptBuilder();
        Receipt receipt = rb.setCost(cost).setPayedAmount(payedAmount).setRegnumber(vehicle.getRegNo()).build();
        CardTerminal cardTerminal = CardTerminal.getCardTerminalInstance();
        return cardTerminal.newCardPayment(creditCard, amount, receipt);
    }

    /**
     * Creates a custom receipt where the inspector an choose cost, payedAmount and regNo
     * @param cost the inspection cost (originally 500)
     * @param payedAmount payed amount if payed by cache (not implemented yet)
     * @param regoNo inspected vehicled registrationnumber
     * @return a custom receipt
     */
    public Receipt customReceipt(double cost, double payedAmount, String regoNo){
        ReceiptBuilder rb = new ReceiptBuilder();
        Receipt receipt = rb.setCost(cost).setPayedAmount(payedAmount).setRegnumber(regoNo).build();
        return receipt;
    }

    /**
     * Ads observer
     * @param obs
     */
    public void addInspecTaskObserver(InspectionTaskObserver obs) {
        inspectionTaskObservers.add(obs);
    }
}
