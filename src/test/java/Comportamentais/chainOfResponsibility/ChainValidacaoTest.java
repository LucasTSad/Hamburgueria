package Comportamentais.chainOfResponsibility;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ChainValidacaoTest {

    private ValidadorPedido corrente;

    @BeforeEach
    void montarCorrente() {
        corrente = new ValidadorCliente();
        corrente.setProximo(new ValidadorValorMinimo())
                .setProximo(new ValidadorFormaPagamento())
                .setProximo(new ValidadorEstoque());
    }

    @Test
    void pedidoValidoPassaPorTodaACorrente() {
        PedidoRequest pedido = new PedidoRequest("João", "X-Burguer", 28.90, "pix", 2);
        assertTrue(corrente.validar(pedido));
    }

    @Test
    void clienteNuloReprovaNoPrimeiroElo() {
        PedidoRequest pedido = new PedidoRequest(null, "X-Burguer", 28.90, "pix", 2);
        assertFalse(corrente.validar(pedido));
    }

    @Test
    void clienteEmBrancoReprovaNoPrimeiroElo() {
        PedidoRequest pedido = new PedidoRequest("   ", "X-Burguer", 28.90, "pix", 2);
        assertFalse(corrente.validar(pedido));
    }

    @Test
    void valorAbaixoDoMinimoReprovaNoSegundoElo() {
        PedidoRequest pedido = new PedidoRequest("João", "X-Burguer", 15.00, "pix", 2);
        assertFalse(corrente.validar(pedido));
    }

    @Test
    void formaPagamentoInvalidaReprovaNoTerceiroElo() {
        PedidoRequest pedido = new PedidoRequest("João", "X-Burguer", 28.90, "bitcoin", 2);
        assertFalse(corrente.validar(pedido));
    }

    @Test
    void quantidadeAcimaDoLimiteReprovaNoQuartoElo() {
        PedidoRequest pedido = new PedidoRequest("João", "X-Burguer", 28.90, "pix", 11);
        assertFalse(corrente.validar(pedido));
    }

    @Test
    void valorExatoDoMinimoEhAprovado() {
        PedidoRequest pedido = new PedidoRequest("João", "X-Burguer", 20.00, "pix", 1);
        assertTrue(corrente.validar(pedido));
    }

    @Test
    void quantidadeNoLimiteEhAprovada() {
        PedidoRequest pedido = new PedidoRequest("João", "X-Burguer", 28.90, "pix", 10);
        assertTrue(corrente.validar(pedido));
    }
}