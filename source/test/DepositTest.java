package test;

import banking.Card;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by leticiamaia on 7/5/17.
 */
public class DepositTest {

    AtmAPI api;
    /**
     * Precisa logar e inserir cartão manulalmente antes de qualquer teste.
     * Os números dos testes seguem a ordem da tabela no exercicio.
     */
    @Before
    public void setUp() {
        api = new AtmAPI();
    }


    @Test
    public void testDeposit1() {
        Card card = new Card(2);
        int pin = 1234;
        int account = 1;
        try {
            api.deposit(card, pin, account, 0.0);
        } catch(Exception e) {

        }
    }

    @Test
    public void testDeposit2() {
        Card card = new Card(2);
        int pin = 1234;
        int account = 1;
        api.deposit(card, pin, account, 0.01);

        //como saber se depositou se precisa esperar 3 dias?
    }
}
