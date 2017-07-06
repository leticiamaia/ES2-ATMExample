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
     * Caso de teste 1
     */
    @Test
    public void testValidWithdraw() {
        Card card = new Card(2);
        int pin = 1234;
        int account = 1;
        api.withdraw(card, pin, account, 20);
        Assert.assertEquals(api.inquiry(card, pin, account), 60);
    }

    /**
     * Colocamos 80 reais no ATM quando ligamos.
     * Caso de teste 2
     */
    @Test
    public void testWithdrawMoreThenATMHas() {
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
     * Caso de teste 3.
     */
    @Test
    public void testWithdrawMoreThenAccountHas() {
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
    * Caso de teste 4.
    */
    @Test
    public void testWithdrawMoreThenAccountAndATMHas() {
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
   * Caso de teste 5.
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
   * Caso de teste 6.
   */
    @Test
    public void testWithdrawOverDailyLimitMoreThenAtmHas() {
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
  * Caso de teste 7.
  */
    @Test
    public void testWithdrawOverDailyLimitMoreThenAccountHas() {
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
     * Caso de teste 8.
     */
    @Test
    public void test3FailureConditionsToguether() {
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
