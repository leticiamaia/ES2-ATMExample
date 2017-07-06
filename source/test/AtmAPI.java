package test;

import atm.ATM;
import banking.*;

/**
 * Created by leticiamaia on 6/26/17.
 */
public class AtmAPI {

    ATM theATM = new ATM(42, "Gordon College", "First National Bank of Podunk",
            null /* We're not really talking to a bank! */);

    public int inquiry(Card card, int pin, int account) {

       /* Balances balances = new Balances();
        Message message = new Message(Message.INQUIRY, card, pin, 1, account, -1, new Money(0));
        Status status = theATM.getNetworkToBank().sendMessage(message, balances);*/
        return 0;
    }

    public void deposit(Card card, int pin, int account, double value) {

    }

    public void transfer(Card card, int pin, int accountFrom, int accountTo, double value) {
    }

    public void withdraw(Card card, int pin, int account, int value) {

    }


}
