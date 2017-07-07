package test;

import atm.transaction.Transaction;
import banking.Card;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by leticiamaia on 7/6/17.
 */
public class InvalidPinTest {
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
    public void testInvalidPinAVL1_TD1() {
        try {
            api.insertCard(-1);
            Assert.fail();
        } catch (Exception e) {

        }
    }

    @Test
    public void testInvalidPinAVL2() {
        try {
            api.insertCard(0);
            Assert.fail();
        } catch (Exception e) {

        }
    }

    @Test
    public void testInvalidPinAVL3_TD4() {
        api.insertCard(1);
        api.insertPin(42);

        Assert.assertEquals(api.getCard(), 1);
    }


    @Test
    public void testInvalidPinAVL4_TD3() {
        api.insertCard(1);

        try {
            api.insertPin(1);
            Assert.fail();
        } catch (Exception e) {

        }
    }

    @Test
    public void testInvalidPinAVL5_TD2() {
        try {
            api.insertCard(4);
            Assert.fail();
        } catch (Exception e) {

        }
    }

}
