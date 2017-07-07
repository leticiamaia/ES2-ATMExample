package test;

import banking.Card;
import banking.Money;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Classe de testes para testar a funcionalidade Withdraw.
 */
public class WithdrawTest {

    private AtmAPI api;
    private Card card;
    private int cardPin;

    @Before
    public void setUp() {
        api = new AtmAPI();
        card = new Card(2);
        cardPin = 1234;
    }

    @Test
    public void testTD1() {
        api.swichOn(4);

        int account = 1;
        try {
            api.withdraw(card, cardPin, account, new Money(20));
        } catch (Exception e) {
            Assert.fail();
        }
        Assert.assertEquals(api.inquiry(card, cardPin, account), 60);
    }

    @Test
    public void testTD2() {
        api.swichOn(4);

        int account = 1;
        try {
            api.withdraw(card, cardPin, account, new Money(20));
            Assert.fail();
        } catch(Exception e) {
        }
    }

    @Test
    public void testTD3() {
        api.swichOn(10);

        int account = 1;
        try {
            api.withdraw(card, cardPin, account, new Money(200));
            Assert.fail();
        } catch(Exception e) {
        }
    }

    @Test
    public void testTD4() {
        api.swichOn(4);

        int account = 1;
        try {
            api.withdraw(card, cardPin, account, new Money(200));
            Assert.fail();
        } catch(Exception e) {
        }
    }

    @Test
    public void testWithdrawOverDailyLimit() {
        api.swichOn(20);

        int account = 3;
        try {
            api.withdraw(card, cardPin, account, new Money(320));
            Assert.fail();
        } catch(Exception e) {

        }
    }

    @Test
    public void testTD5() {
        api.swichOn(15);

        int account = 3;
        try {
            api.withdraw(card, cardPin, account, new Money(320));
            Assert.fail();
        } catch(Exception e) {

        }
    }

    @Test
    public void testTD6() {
        api.swichOn(300);

        int account = 3;
        try {
            api.withdraw(card, cardPin, account, new Money(5020));
            Assert.fail();
        } catch(Exception e) {
        }
    }

    @Test
    public void testTD7() {
        api.swichOn(15);

        int account = 3;
        try {
            api.withdraw(card, cardPin, account, new Money(5020));
            Assert.fail();
        } catch(Exception e) {
        }
    }

}
