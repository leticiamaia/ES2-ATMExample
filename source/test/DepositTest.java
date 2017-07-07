package test;

import banking.Card;
import banking.Money;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Classe de testes para testar a funcionalidade Deposit.
 */
public class DepositTest {

    private static final String CONTA_INVALIDA = "Não deveria ser possível depositar conta inválida";
    private static final String VALOR_ZERO = "Não deveria ser possível depositar valor 0.";
    private static final String SEM_EXCEÇÃO = "Não deveria lançar exceção.";
    private AtmAPI api;
    private Card card;
    private int cardPin;

    @Before
    public void setUp() {
        api = new AtmAPI();
        card = new Card(2);
        cardPin = 1234;
    }

    /*
     * Testes Análise Valor Limite -> AVL{ID}
     * Testes Partição por Equivalência -> PE{ID}
     * Testes Tabela de Decisão -> TD{ID}
     *
     * Casos de testes iguais de cada técnica foram
     * concatenados em um mesmo teste.
     * Exemplo: testDespositAVL1_PE1 é:
     * Caso de Teste 1 de Análise Valor Limite e
     * Caso de Teste 1 em Partição por Equivalência.
     */

    @Test
    public void testDespositAVL1_PE1_TD1() {
        int accountTo = 1;
        Money money = new Money(0, 0);

        try {
            api.deposit(card, cardPin, accountTo, money);
            Assert.fail(VALOR_ZERO);
        } catch (Exception e) {

        }
    }

    @Test
    public void testDespositAVL2() {
        int accountTo = 1;
        Money money = new Money(0, 1);

        try {
            api.deposit(card, cardPin, accountTo, money);
        } catch (Exception e) {
            Assert.fail(SEM_EXCEÇÃO);
        }
    }

    @Test
    public void testDespositAVL3_PE2_TD2() {
        int accountTo = 1;
        Money money = new Money(25);

        try {
            api.deposit(card, cardPin, accountTo, money);
        } catch (Exception e) {
            Assert.fail(SEM_EXCEÇÃO);
        }
    }

    @Test
    public void testDespositAVL4() {
        int accountTo = 1;
        Money money = new Money(10000000000000000000);

        try {
            api.deposit(card, cardPin, accountTo, money);
        } catch (Exception e) {
            Assert.fail(SEM_EXCEÇÃO);
        }
    }

    @Test
    public void testDespositAVL5_PE3_TD3() {
        int accountTo = 2;
        Money money = new Money(0, 0);

        try {
            api.deposit(card, cardPin, accountTo, money);
            Assert.fail(VALOR_ZERO);
        } catch (Exception e) {

        }
    }

    @Test
    public void testDespositAVL6() {
        int accountTo = 2;
        Money money = new Money(0, 1);

        try {
            api.deposit(card, cardPin, accountTo, money);
            Assert.fail(CONTA_INVALIDA);
        } catch (Exception e) {
        }
    }

    @Test
    public void testDespositAVL7_PE4_TD4() {
        int accountTo = 2;
        Money money = new Money(25);

        try {
            api.deposit(card, cardPin, accountTo, money);
            Assert.fail(CONTA_INVALIDA);
        } catch (Exception e) {
        }
    }

    @Test
    public void testDespositAVL8() {
        int accountTo = 2;
        Money money = new Money(10000000000000000000);

        try {
            api.deposit(card, cardPin, accountTo, money);
            Assert.fail(CONTA_INVALIDA);
        } catch (Exception e) {
        }
    }
}
