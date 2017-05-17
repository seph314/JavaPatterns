/*
* This program is created by Anders Pettersson as a seminar task in the course
* Object oriented design (IV1350) at KTH University.
*/
package inspection.model;

/**
 * Created by Anders on 2017-04-25.
 * Amount contains the inspection cost and the payed amount from customer
 */
public class Amount {

    private double cost;
    private double payedAmount;

    /**
     * Amount constructor
     * @param cost
     * @param payedAmount
     */
    public Amount(double cost, double payedAmount) {
        this.cost = cost;
        this.payedAmount = payedAmount;
    }

    /**
     * Returns the inspectioncost
     * @return
     */
    public double getCost() {
        return cost;
    }

    /**
     * Returns the payedAmount (if payed in cash, not available in this program yet)
     * @return
     */
    public double getPayedAmount() {
        return payedAmount;
    }
}
