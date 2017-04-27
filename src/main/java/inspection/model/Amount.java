package inspection.model;

/**
 * Created by Anders on 2017-04-25.
 * Amount contains the inspection cost and the payed amount from customer
 */

public class Amount {

    double cost;
    double payedAmount;

    public Amount(double cost, double payedAmount) {
        this.cost = cost;
        this.payedAmount = payedAmount;
    }

    public double getCost() {
        return cost;
    }

    public double getPayedAmount() {
        return payedAmount;
    }
}
