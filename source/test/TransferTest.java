package test;

import banking.Card;
import banking.Money;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Classe de testes para testar a funcionalidade Transfer.
 */
public class TransferTest {

    private static final String CONTA_INEXISTENTE = "Não deveria ser possível transferir pra conta inexistente";
    private static final String SEM_EXCEÇÃO = "Não deveria lançar exceção.";
    private static final String VALOR_ZERO = "Não deveria ser possível transferir valor 0.";
    private static final String CONTA_IGUAL = "Não deveria ser possível transferir pra mesma conta.";

    private AtmAPI api;
    private Card card;
    private int cardPin;

    @Before
    public void setUp() {
        api = new AtmAPI();
        api.swichOn(10);
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
    public void testTransferAVL1_PE1_TD1() {
        int accountFrom = 1;
        int accountTo = 1;
        Money money = new Money(0, 0);

        try {
            api.transfer(card, cardPin, accountFrom, accountTo, money);
            Assert.fail(VALOR_ZERO);
        } catch (Exception e) {
        }
    }

    @Test
    public void testTransferAVL2() {
        int accountFrom = 1;
        int accountTo = 1;
        Money money = new Money(0, 1);

        try {
            api.transfer(card, cardPin, accountFrom, accountTo, money);
            Assert.fail(CONTA_IGUAL);
        } catch (Exception e) {
        }
    }

    @Test
    public void testTransferAVL3_PE2_TD4() {
        int accountFrom = 1;
        int accountTo = 1;
        Money money = new Money(101, 0);

        try {
            api.transfer(card, cardPin, accountFrom, accountTo, money);
            Assert.fail(CONTA_IGUAL);
        } catch (Exception e) {
        }
    }

    @Test
    public void testTransferAVL4() {
        int accountFrom = 1;
        int accountTo = 1;
        Money money = new Money(10000000000000000000, 0);

        try {
            api.transfer(card, cardPin, accountFrom, accountTo, money);
            Assert.fail(CONTA_IGUAL);
        } catch (Exception e) {
        }
    }

    @Test
    public void testTransferAVL5_PE3() {
        int accountFrom = 1;
        int accountTo = 2;
        Money money = new Money(0, 0);

        try {
            api.transfer(card, cardPin, accountFrom, accountTo, money);
            Assert.fail(VALOR_ZERO);
        } catch (Exception e) {

        }
    }

    @Test
    public void testTransferAVL6() {
        int accountFrom = 1;
        int accountTo = 2;
        Money money = new Money(0, 1);

        try {
            api.transfer(card, cardPin, accountFrom, accountTo, money);
            Assert.fail(CONTA_INEXISTENTE);
        } catch (Exception e) {
        }
    }

    @Test
    public void testTransferAVL7_PE4_TD3() {
        int accountFrom = 1;
        int accountTo = 2;
        Money money = new Money(101, 0);

        try {
            api.transfer(card, cardPin, accountFrom, accountTo, money);
            Assert.fail(CONTA_INEXISTENTE);
        } catch (Exception e) {
        }
    }

    @Test
    public void testTransferAVL8() {
        int accountFrom = 1;
        int accountTo = 2;
        Money money = new Money(10000000000000000000, 0);

        try {
            api.transfer(card, cardPin, accountFrom, accountTo, money);
            Assert.fail(CONTA_INEXISTENTE);
        } catch (Exception e) {
        }
    }

    @Test
    public void testTransferAVL9_PE5() {
        int accountFrom = 1;
        int accountTo = 3;
        Money money = new Money(0, 0);

        try {
            api.transfer(card, cardPin, accountFrom, accountTo, money);
            Assert.fail(VALOR_ZERO);
        } catch (Exception e) {
        }
    }

    @Test
    public void testTransferAVL10() {
        int accountFrom = 1;
        int accountTo = 3;
        Money money = new Money(0, 1);

        try {
            api.transfer(card, cardPin, accountFrom, accountTo, money);
        } catch (Exception e) {
            Assert.fail(SEM_EXCEÇÃO);
        }
    }

    @Test
    public void testTransferAVL11_PE6_TD2() {
        int accountFrom = 1;
        int accountTo = 3;
        Money money = new Money(101, 0);

        try {
            api.transfer(card, cardPin, accountFrom, accountTo, money);
        } catch (Exception e) {
            Assert.fail(SEM_EXCEÇÃO);
        }
    }

    @Test
    public void testTransferAVL12() {
        int accountFrom = 1;
        int accountTo = 3;
        Money money = new Money(10000000000000000000, 0);

        try {
            api.transfer(card, cardPin, accountFrom, accountTo, money);
        } catch (Exception e) {
            Assert.fail(SEM_EXCEÇÃO);
        }
    }

    @Test
    public void testTransferAVL13_PE7() {
        int accountFrom = 2;
        int accountTo = 1;
        Money money = new Money(0, 0);

        try {
            api.transfer(card, cardPin, accountFrom, accountTo, money);
            Assert.fail(VALOR_ZERO);
        } catch (Exception e) {

        }
    }

    @Test
    public void testTransferAVL14() {
        int accountFrom = 2;
        int accountTo = 1;
        Money money = new Money(0, 1);

        try {
            api.transfer(card, cardPin, accountFrom, accountTo, money);
            Assert.fail(CONTA_INEXISTENTE);
        } catch (Exception e) {
        }
    }

    @Test
    public void testTransferAVL15_PE8() {
        int accountFrom = 2;
        int accountTo = 1;
        Money money = new Money(101, 0);

        try {
            api.transfer(card, cardPin, accountFrom, accountTo, money);
            Assert.fail(CONTA_INEXISTENTE);
        } catch (Exception e) {
        }
    }

    @Test
    public void testTransferAVL16() {
        int accountFrom = 2;
        int accountTo = 1;
        Money money = new Money(10000000000000000000, 0);

        try {
            api.transfer(card, cardPin, accountFrom, accountTo, money);
            Assert.fail(CONTA_INEXISTENTE);
        } catch (Exception e) {
        }
    }

    @Test
    public void testTransferAVL17_PE9() {
        int accountFrom = 2;
        int accountTo = 2;
        Money money = new Money(0, 0);

        try {
            api.transfer(card, cardPin, accountFrom, accountTo, money);
            Assert.fail(VALOR_ZERO);
        } catch (Exception e) {

        }
    }

    @Test
    public void testTransferAVL18() {
        int accountFrom = 2;
        int accountTo = 2;
        Money money = new Money(0, 1);

        try {
            api.transfer(card, cardPin, accountFrom, accountTo, money);
            Assert.fail(CONTA_INEXISTENTE);
        } catch (Exception e) {
        }
    }

    @Test
    public void testTransferAVL19_PE10() {
        int accountFrom = 2;
        int accountTo = 2;
        Money money = new Money(101, 0);

        try {
            api.transfer(card, cardPin, accountFrom, accountTo, money);
            Assert.fail(CONTA_INEXISTENTE);
        } catch (Exception e) {
        }
    }

    @Test
    public void testTransferAVL20() {
        int accountFrom = 2;
        int accountTo = 2;
        Money money = new Money(10000000000000000000, 0);

        try {
            api.transfer(card, cardPin, accountFrom, accountTo, money);
            Assert.fail(CONTA_INEXISTENTE);
        } catch (Exception e) {
        }
    }

    @Test
    public void testTransferAVL21_PE11() {
        int accountFrom = 2;
        int accountTo = 3;
        Money money = new Money(0, 0);

        try {
            api.transfer(card, cardPin, accountFrom, accountTo, money);
            Assert.fail(VALOR_ZERO);
        } catch (Exception e) {

        }
    }

    @Test
    public void testTransferAVL22() {
        int accountFrom = 2;
        int accountTo = 3;
        Money money = new Money(0, 1);

        try {
            api.transfer(card, cardPin, accountFrom, accountTo, money);
            Assert.fail(CONTA_INEXISTENTE);
        } catch (Exception e) {
        }
    }

    @Test
    public void testTransferAVL23_PE12() {
        int accountFrom = 2;
        int accountTo = 3;
        Money money = new Money(101, 0);

        try {
            api.transfer(card, cardPin, accountFrom, accountTo, money);
            Assert.fail(CONTA_INEXISTENTE);
        } catch (Exception e) {
        }
    }

    @Test
    public void testTransferAVL24() {
        int accountFrom = 2;
        int accountTo = 3;
        Money money = new Money(10000000000000000000, 0);

        try {
            api.transfer(card, cardPin, accountFrom, accountTo, money);
            Assert.fail(CONTA_INEXISTENTE);
        } catch (Exception e) {
        }
    }

    @Test
    public void testTransferAVL25_PE13() {
        int accountFrom = 3;
        int accountTo = 1;
        Money money = new Money(0, 0);

        try {
            api.transfer(card, cardPin, accountFrom, accountTo, money);
            Assert.fail(VALOR_ZERO);
        } catch (Exception e) {
        }
    }

    @Test
    public void testTransferAVL26() {
        int accountFrom = 3;
        int accountTo = 1;
        Money money = new Money(0, 1);

        try {
            api.transfer(card, cardPin, accountFrom, accountTo, money);
        } catch (Exception e) {
            Assert.fail(SEM_EXCEÇÃO);
        }
    }

    @Test
    public void testTransferAVL27_PE14() {
        int accountFrom = 3;
        int accountTo = 1;
        Money money = new Money(101, 0);

        try {
            api.transfer(card, cardPin, accountFrom, accountTo, money);
        } catch (Exception e) {
            Assert.fail(SEM_EXCEÇÃO);
        }
    }

    @Test
    public void testTransferAVL28() {
        int accountFrom = 3;
        int accountTo = 1;
        Money money = new Money(10000000000000000000, 0);

        try {
            api.transfer(card, cardPin, accountFrom, accountTo, money);
        } catch (Exception e) {
            Assert.fail(SEM_EXCEÇÃO);
        }
    }

    @Test
    public void testTransferAVL29_PE15() {
        int accountFrom = 3;
        int accountTo = 2;
        Money money = new Money(0, 0);

        try {
            api.transfer(card, cardPin, accountFrom, accountTo, money);
            Assert.fail(VALOR_ZERO);
        } catch (Exception e) {

        }
    }

    @Test
    public void testTransferAVL30() {
        int accountFrom = 3;
        int accountTo = 2;
        Money money = new Money(0, 1);

        try {
            api.transfer(card, cardPin, accountFrom, accountTo, money);
            Assert.fail(CONTA_INEXISTENTE);
        } catch (Exception e) {
        }
    }

    @Test
    public void testTransferAVL31_PE16() {
        int accountFrom = 3;
        int accountTo = 2;
        Money money = new Money(101, 0);

        try {
            api.transfer(card, cardPin, accountFrom, accountTo, money);
            Assert.fail(CONTA_INEXISTENTE);
        } catch (Exception e) {
        }
    }

    @Test
    public void testTransferAVL32() {
        int accountFrom = 3;
        int accountTo = 2;
        Money money = new Money(10000000000000000000, 0);

        try {
            api.transfer(card, cardPin, accountFrom, accountTo, money);
            Assert.fail(CONTA_INEXISTENTE);
        } catch (Exception e) {
        }
    }

    @Test
    public void testTransferAVL33_PE17() {
        int accountFrom = 3;
        int accountTo = 3;
        Money money = new Money(0, 0);

        try {
            api.transfer(card, cardPin, accountFrom, accountTo, money);
            Assert.fail(VALOR_ZERO);
        } catch (Exception e) {
        }
    }

    @Test
    public void testTransferAVL34() {
        int accountFrom = 3;
        int accountTo = 3;
        Money money = new Money(0, 1);

        try {
            api.transfer(card, cardPin, accountFrom, accountTo, money);
            Assert.fail(CONTA_IGUAL);
        } catch (Exception e) {
        }
    }

    @Test
    public void testTransferAVL35_PE18() {
        int accountFrom = 3;
        int accountTo = 3;
        Money money = new Money(101, 0);

        try {
            api.transfer(card, cardPin, accountFrom, accountTo, money);
            Assert.fail(CONTA_IGUAL);
        } catch (Exception e) {
        }
    }

    @Test
    public void testTransferAVL36() {
        int accountFrom = 3;
        int accountTo = 3;
        Money money = new Money(10000000000000000000, 0);

        try {
            api.transfer(card, cardPin, accountFrom, accountTo, money);
            Assert.fail(CONTA_IGUAL);
        } catch (Exception e) {
        }
    }
}
