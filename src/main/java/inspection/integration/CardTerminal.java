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

   private final CreditCard creditCard;
   private final Amount amount;
   private final Receipt receipt;

    public CardTerminal(CreditCard creditCard, Amount amount, Receipt receipt) {
        this.creditCard = creditCard;
        this.amount = amount;
        this.receipt = receipt;
    }

    public void newCardPayment(CreditCard creditCard, Amount amount){
        int cost = (int) amount.getCost();
        final boolean authorized = paymentAuthorization.authorizePayment(creditCard, cost);
    }
}
