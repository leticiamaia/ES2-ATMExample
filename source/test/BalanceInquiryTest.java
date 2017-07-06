package test;

import atm.ATM;
import atm.Session;
import atm.transaction.Inquiry;
import atm.transaction.Transaction;
import banking.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.net.Inet4Address;

/**
 * Created by leticiamaia on 7/5/17.
 */
public class BalanceInquiryTest {

    AtmAPI api;

    /**
     * Precisa logar e inserir cartão manulalmente antes de qualquer teste.
     */
    @Before
    public void setUp() {
        api = new AtmAPI();
    }


    @Test
    public void testBalanceInquiryValidAccount() {
        Card card = new Card(2);
        int pin = 1234;
        int account = 1;
        Assert.assertEquals(api.inquiry(card, pin, account), 100);
    }

    @Test
    public void testBalanceInquiryWrongAccount() {
        Card card = new Card(2);
        int pin = 1234;
        int account = 2;

        try {
            api.inquiry(card, pin, account);
            Assert.fail();
        } catch (Exception e) {

        }
    }
}
