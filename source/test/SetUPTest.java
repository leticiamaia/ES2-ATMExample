package test;

import atm.transaction.Transaction;
import banking.Card;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.Before;

public class SetUPTest {

    AtmAPI api;
    /*
     * Os números dos testes são nomeados de acordo com a tabela do exercicio.
     */
    @Before
    public void setUp() {
        api = new AtmAPI();
    }

    /*
     *  Funcionalidade de ligar.
     */

    @Test
    public void testSwichOnAVL1_TD1() {
        api.swichOn(1);

        Assert.assertTrue(api.isSystemOn());
    }

    @Test
    public void testSwichOnAVL2_TD2() {
        api.swichOn(0);

        Assert.assertTrue(api.isSystemOn());
    }

    /**
     * Exceção esperada.
     */
    @Test
    public void testSwichOnAVL3_PE2() {
        try {
            api.swichOn(-1);
            Assert.fail();
        } catch(Exception e) {

        }
    }

    @Test
    public void testSwichOnPE1() {
        api.swichOn(20);

        Assert.assertTrue(api.isSystemOn());
    }

    /**
     * Exceção esperada.
     */
    @Test
    public void testSwichPE3() {
        try {
            api.swichOn(-20);
            Assert.fail();
        } catch(Exception e) {

        }
    }

    /*
     *  Funcionalidade de desligar.
     */

    @Test
    public void testSwichOff() {
        api.swichOff();
        Assert.assertFalse(api.isSystemOn());
    }

    /*
     *  Funcionalidade de inserirCartão.
     *  Para rodar esses testes é preciso ligar o ATM primeiro.
     */


    /**
     * Deve lançar exceção pois número do cartão é inválido.
     */
    @Test
    public void testInsertCardAVL1() {
        try {
            api.insertCard(0);
            Assert.fail();
        } catch (Exception e) {

        }
    }

    @Test
    public void testInsertCardAVL2_PE2_TD2() {
        api.insertCard(1);
        Assert.assertEquals(api.getCard(), 1);
    }

    @Test
    public void testInsertCardAVL3() {
        api.insertCard(2);
        Assert.assertEquals(api.getCard(), 2);
    }

    /*
     * Deve lançar exceção pois número do cartão é inválido.
     */
    @Test
    public void testInsertCardAVL4_TD3() {
        try {
            api.insertCard(3);
            Assert.fail();
        } catch (Exception e) {

        }
    }

    /*
    * Deve lançar exceção pois número do cartão é inválido.
    */
    @Test
    public void testInsertCardPE1_TD1() {
        try {
            api.insertCard(-20);
            Assert.fail();
        } catch (Exception e) {

        }
    }

    /*
     * Deve lançar exceção pois número do cartão é inválido.
     */
    @Test
    public void testInsertCardPE3() {
        try {
            api.insertCard(20);
            Assert.fail();
        } catch (Exception e) {

        }
    }
}
