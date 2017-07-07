package test;

import banking.Card;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by leticiamaia on 7/5/17.
 */
public class WithdrawTest {

    AtmAPI api;

    /**
     * Precisa logar e inserir cartão manulalmente antes de qualquer teste.
     * Devmos inserir cartão 2 com senha 1234
     *
     */

    @Before
    public void setUp() {
        api = new AtmAPI();
    }


    /**
     * Colocamos 80 reais no ATM quando ligamos.
     */
    @Test
    public void testTD1() {
        Card card = new Card(2);
        int pin = 1234;
        int account = 1;
        api.withdraw(card, pin, account, 20);
        Assert.assertEquals(api.inquiry(card, pin, account), 60);
    }

    /**
     * Colocamos 80 reais no ATM quando ligamos.
     */
    @Test
    public void testTD2() {
        Card card = new Card(2);
        int pin = 1234;
        int account = 1;
        try {
            api.withdraw(card, pin, account, 20);
            Assert.fail();
        } catch(Exception e) {

        }
    }

     /*
     * Colocamos 200 reais no ATM quando ligamos.
     */
    @Test
    public void testTD3() {
        Card card = new Card(2);
        int pin = 1234;
        int account = 1;
        try {
            api.withdraw(card, pin, account, 200);
            Assert.fail();
        } catch(Exception e) {

        }
    }

    /*
    * Colocamos 80 reais no ATM quando ligamos.
    */
    @Test
    public void testTD4() {
        Card card = new Card(2);
        int pin = 1234;
        int account = 1;
        try {
            api.withdraw(card, pin, account, 200);
            Assert.fail();
        } catch(Exception e) {

        }
    }


    /*
   * Colocamos 400 reais no ATM quando ligamos.
   */
    @Test
    public void testWithdrawOverDailyLimit() {
        Card card = new Card(2);
        int pin = 1234;
        int account = 3;
        try {
            api.withdraw(card, pin, account, 320);
            Assert.fail();
        } catch(Exception e) {

        }
    }

    /*
   * Colocamos 300 reais no ATM quando ligamos.
   */
    @Test
    public void testTD5() {
        Card card = new Card(2);
        int pin = 1234;
        int account = 3;
        try {
            api.withdraw(card, pin, account, 320);
            Assert.fail();
        } catch(Exception e) {

        }
    }

    /*
  * Colocamos 6000 reais no ATM quando ligamos.
  */
    @Test
    public void testTD6() {
        Card card = new Card(2);
        int pin = 1234;
        int account = 3;
        try {
            api.withdraw(card, pin, account, 5020);
            Assert.fail();
        } catch(Exception e) {

        }
    }

    /*
     * Colocamos 300 reais no ATM quando ligamos.
     */
    @Test
    public void testTD7() {
        Card card = new Card(2);
        int pin = 1234;
        int account = 3;
        try {
            api.withdraw(card, pin, account, 5020);
            Assert.fail();
        } catch(Exception e) {

        }
    }

}
