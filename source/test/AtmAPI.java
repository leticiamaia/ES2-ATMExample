package test;

import atm.ATM;
import atm.Session;
import atm.transaction.Deposit;
import atm.transaction.Transaction;
import banking.*;
import simulation.Simulation;

public class AtmAPI {

    public AtmAPI() {

    }

    ATM theATM = new ATM(42, "Gordon College", "First National Bank of Podunk",
            null /* We're not really talking to a bank! */);

    public boolean systemOn() {
        return false;
    }

    public void swichOn(int bills) {

    }

    public void swichOff() {

    }

    public void insertCard(int cardNumber) {

    }

    public void insertPin(int pin) {

    }

    public int getCard() {
       return 0;
    }

    public int inquiry(Card card, int pin, int account) {

       /* Balances balances = new Balances();
        Message message = new Message(Message.INQUIRY, card, pin, 1, account, -1, new Money(0));
        Status status = theATM.getNetworkToBank().sendMessage(message, balances);*/
        return 0;
    }

    /**
     * Facade da operação de Deposit.
     *
     * Infelizmente o código não está rodando da forma correta pois o sistema
     * é muito acoplado à interface.
     *
     * @param card Cartão que vai realizar o depósito.
     * @param pin Pin do Cartão.
     * @param accountTo Conta para fazer o depósito.
     * @param money Valor a ser depositado.
     * @throws Transaction.CardRetained
     */
    public void deposit(Card card, int pin, int accountTo, Money money) throws Transaction.CardRetained {
        ATM atm = new ATM(42, "Gordon College", "First National Bank of Podunk",
                null);
        Simulation simulation = new Simulation(atm);

        atm.SwichOn(4);

        Session session = new Session(atm);

        Deposit deposit = new Deposit(atm, session, card, pin);

        Message depositMessage = new Message(1, card, pin,
                0, -1, accountTo, money);

        deposit.setAmount(money);
        deposit.setTo(accountTo);
        deposit.setMessage(depositMessage);
        // Workaround to remove coupling with IDE
        // Starting the transaction in the state SENDING_TO_BANK_STATE
        deposit.setState(2);

        deposit.performTransaction();
    }

    public void transfer(Card card, int pin, int accountFrom, int accountTo, double value) {
    }

    public void withdraw(Card card, int pin, int account, int value) {

    }


}
