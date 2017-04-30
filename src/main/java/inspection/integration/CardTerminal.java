package inspection.integration;

import inspection.model.Amount;
import inspection.model.Receipt;
import se.kth.iv1350.payauth.CreditCard;
import se.kth.iv1350.payauth.PaymentAuthorization;

/**
 * Created by Anders on 2017-04-28.
 */
public class CardTerminal {

    PaymentAuthorization paymentAuthorization;

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
        boolean authorized = true;  //paymentAuthorization.authorizePayment(creditCard, cost);
        if (authorized)
            return receipt.createReceiptString();
        else
            return "Payment denied";
    }
}
