package test;

import atm.ATM;
import atm.Session;
import atm.transaction.Deposit;
import atm.transaction.Transaction;
import banking.*;
import simulation.Simulation;

/**
 * Facade para as funcionalidades do ATM.
 */
public class AtmAPI {

    private ATM atm;
    private Simulation simulation;

    /**
     * Construtor padrão da API para o ATM.
     */
    public AtmAPI() {
        this.atm = new ATM(42, "Gordon College", "First National Bank of Podunk",
                null);
        this.simulation = new Simulation(atm);
    }

    public boolean isSystemOn() {
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
     */
    public void deposit(Card card, int pin, int accountTo, Money money) throws Exception {
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

    /**
     * Facade da operação de Transfer.
     *
     * @param card Cartão que vai realizar a transferência.
     * @param pin Pin do Cartão.
     * @param accountFrom Conta que fará a transferência.
     * @param accountTo Conta que receberá a transferência.
     * @param money Valor a ser transferido.
     */
    public void transfer(Card card, int pin, int accountFrom, int accountTo, Money money) throws Exception {
    }

    /**
     * Facade da operação de Withdraw.
     *
     * @param card Cartão que vai realizar o saque.
     * @param pin Pin do Cartão.
     * @param accountFrom Conta que o dinheiro será sacado.
     * @param money Valor a ser sacado.
     */
    public void withdraw(Card card, int pin, int accountFrom, Money money) throws Exception {
    }


}
