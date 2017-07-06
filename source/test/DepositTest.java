package test;

import atm.transaction.Transaction;
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
    public void testDespositAVL3() {
        Card card = new Card(2);
        int pin = 1234;
        int accountTo = 1;
        int value = 25;

        try {
            api.deposit(card, pin, accountTo, value);
        } catch (Transaction.CardRetained cardRetained) {
            Assert.fail("Não deveria dar erro com o cartão.");
        }
    }
}
