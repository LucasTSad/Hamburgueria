package Criacao.factoryMethod;

import Criacao.singleton.ConfiguracaoHamburgueria;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PedidoFactoryTest {

    @BeforeEach
    void configurarTaxaEntrega() {
        ConfiguracaoHamburgueria.getInstance().setTaxaEntrega(5.99);
    }

    // -- Criação por tipo -------------------------------------------------

    @Test
    void criarPedidoBalcaoRetornaInstanciaCorreta() {
        IPedido pedido = PedidoFactory.criarPedido("balcao", 30.00);
        assertInstanceOf(PedidoBalcao.class, pedido);
    }

    @Test
    void criarPedidoDeliveryRetornaInstanciaCorreta() {
        IPedido pedido = PedidoFactory.criarPedido("delivery", 30.00, "Rua A, 1");
        assertInstanceOf(PedidoDelivery.class, pedido);
    }

    @Test
    void criarPedidoMesaRetornaInstanciaCorreta() {
        IPedido pedido = PedidoFactory.criarPedido("mesa", 30.00, 3);
        assertInstanceOf(PedidoMesa.class, pedido);
    }

    @Test
    void tipoInvalidoLancaExcecao() {
        assertThrows(IllegalArgumentException.class, () ->
                PedidoFactory.criarPedido("drive-thru", 30.00)
        );
    }

    // -- Cálculo de total -------------------------------------------------

    @Test
    void pedidoBalcaoNaoAplicaTaxaExtra() {
        IPedido pedido = PedidoFactory.criarPedido("balcao", 28.90);
        assertEquals(28.90, pedido.calcularTotal(), 0.01);
    }

    @Test
    void pedidoDeliveryAplicaTaxaDeEntrega() {
        IPedido pedido = PedidoFactory.criarPedido("delivery", 28.90, "Rua das Flores, 42");
        assertEquals(34.89, pedido.calcularTotal(), 0.01);
    }

    @Test
    void pedidoMesaAplicaDezPorcentoDeServico() {
        IPedido pedido = PedidoFactory.criarPedido("mesa", 100.00, 5);
        assertEquals(110.00, pedido.calcularTotal(), 0.01);
    }

    // -- Descrição --------------------------------------------------------

    @Test
    void pedidoBalcaoRetornaDescricaoNaoNula() {
        IPedido pedido = PedidoFactory.criarPedido("balcao", 28.90);
        assertNotNull(pedido.getDescricao());
    }

    @Test
    void pedidoMesaIncluiNumeroNaDescricao() {
        IPedido pedido = PedidoFactory.criarPedido("mesa", 50.00, 7);
        assertTrue(pedido.getDescricao().contains("7"));
    }

    @Test
    void pedidoDeliveryIncluiEnderecoNaDescricao() {
        IPedido pedido = PedidoFactory.criarPedido("delivery", 50.00, "Av. Brasil, 100");
        assertTrue(pedido.getDescricao().contains("Av. Brasil, 100"));
    }
}