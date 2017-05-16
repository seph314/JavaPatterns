/*
* This program is created by Anders Pettersson as a seminar task in the course
* Object oriented design (IV1350) at KTH University.
*/
package inspection.integration;

import inspection.model.Amount;
import inspection.model.Receipt;
import se.kth.iv1350.payauth.CreditCard;
import se.kth.iv1350.payauth.PaymentAuthorization;

/**
 * Created by Anders on 2017-04-28.
 */
public class CardTerminal {

    private PaymentAuthorization paymentAuthorization = new PaymentAuthorization();

    /**
     * Constructor
     */
    public CardTerminal() {

    }

    /**
     * Authorizes payment and returns receipt string
     * @param creditCard
     * @param amount
     * @param receipt
     * @return
     */
    public String newCardPayment(CreditCard creditCard, Amount amount, Receipt receipt){
        int cost = (int) amount.getCost();
        boolean authorized = paymentAuthorization.authorizePayment(creditCard, cost);
        System.out.println(authorized);
        if (authorized)
            return receipt.createReceiptString();
        else
            return "Payment denied";
    }
}
