package Comportamentais.strategy;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StrategyDescontoTest {

    @Test
    void semDescontoRetornaZero() {
        assertEquals(0, new DescontoNenhum().calcularDesconto(100.00), 0.01);
    }

    @Test
    void semDescontoValorFinalIgualAoOriginal() {
        PedidoComDesconto pedido = new PedidoComDesconto(50.00, new DescontoNenhum());
        assertEquals(50.00, pedido.getValorFinal(), 0.01);
    }

    @Test
    void descontoDezPorcentoCalculaCorretamente() {
        assertEquals(10.00, new DescontoPercentual(10).calcularDesconto(100.00), 0.01);
    }

    @Test
    void descontoPercentualInvalidoLancaExcecao() {
        assertThrows(IllegalArgumentException.class, () -> new DescontoPercentual(-1));
        assertThrows(IllegalArgumentException.class, () -> new DescontoPercentual(101));
    }

    @Test
    void descontoCemPorcentoZeraValor() {
        PedidoComDesconto pedido = new PedidoComDesconto(50.00, new DescontoPercentual(100));
        assertEquals(0.00, pedido.getValorFinal(), 0.01);
    }

    @Test
    void fidelidadeAplicaCincoReaisEmPedidoAcimaDeCinco() {
        assertEquals(5.00, new DescontoFidelidade().calcularDesconto(80.00), 0.01);
    }

    @Test
    void fidelidadeNaoUltrapassaValorDoPedido() {
        assertEquals(3.00, new DescontoFidelidade().calcularDesconto(3.00), 0.01);
    }

    @Test
    void happyHourAplicaVintePorcentoAcimaDeQuinquenta() {
        assertEquals(12.00, new DescontoHappyHour().calcularDesconto(60.00), 0.01);
    }

    @Test
    void happyHourNaoAplicaAbaixoDeQuinquenta() {
        assertEquals(0.00, new DescontoHappyHour().calcularDesconto(40.00), 0.01);
    }

    @Test
    void trocarEstrategiaAlteraValorFinal() {
        PedidoComDesconto pedido = new PedidoComDesconto(100.00, new DescontoNenhum());
        assertEquals(100.00, pedido.getValorFinal(), 0.01);
        pedido.setEstrategia(new DescontoPercentual(20));
        assertEquals(80.00, pedido.getValorFinal(), 0.01);
    }
}