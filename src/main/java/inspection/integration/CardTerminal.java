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
 * Represents a card terminal which can make a new payment
 *
 */
public class CardTerminal {

    private static CardTerminal cardTerminal;
    private PaymentAuthorization paymentAuthorization = new PaymentAuthorization();

    /**
     * Singleton constructor that prevents clients from using the constructor
     */
    private  CardTerminal() {

    }

    /**
     * Controls the accessible (allowed) instances by checking if
     * there already is an instance and creates an instance if there is none.
     */
    public static CardTerminal getCardTerminalInstance(){
        if (cardTerminal == null){
            cardTerminal = new CardTerminal();
        }
        return cardTerminal;
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
        if (authorized)
            return receipt.createReceiptString();
        else
            return "Payment denied";
    }
}
