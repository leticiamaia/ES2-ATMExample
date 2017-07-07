package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Classe de testes para testar a funcionalidade InvalidPin.
 */
public class InvalidPinTest {

    private AtmAPI api;

    /**
     * Precisa logar e inserir cartão manulalmente antes de qualquer teste.
     * Os números dos testes seguem a ordem da tabela no exercicio.
     */
    @Before
    public void setUp() {
        api = new AtmAPI();
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
