package Comportamentais.memento;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MementoPedidoTest {

    @Test
    void salvarCriaSnapshotComValoresAtuais() {
        PedidoEmEdicao pedido = new PedidoEmEdicao("X-Burguer", 25.00, "sem cebola");
        MementoPedido snap    = pedido.salvar();
        assertEquals("X-Burguer", snap.getItem());
        assertEquals(25.00,       snap.getValor(), 0.01);
        assertEquals("sem cebola",snap.getObservacao());
    }

    @Test
    void salvarNaoAlteraEstadoAtual() {
        PedidoEmEdicao pedido = new PedidoEmEdicao("X-Burguer", 25.00, "sem cebola");
        pedido.salvar();
        assertEquals("X-Burguer", pedido.getItem());
    }

    // -- Restaurar --------------------------------------------------------

    @Test
    void restaurarRecuperaItemAnterior() {
        PedidoEmEdicao pedido = new PedidoEmEdicao("X-Burguer", 25.00, "normal");
        MementoPedido  snap   = pedido.salvar();
        pedido.setItem("X-Bacon");
        pedido.restaurar(snap);
        assertEquals("X-Burguer", pedido.getItem());
    }

    @Test
    void restaurarRecuperaValorAnterior() {
        PedidoEmEdicao pedido = new PedidoEmEdicao("X-Burguer", 25.00, "normal");
        MementoPedido  snap   = pedido.salvar();
        pedido.setValor(99.00);
        pedido.restaurar(snap);
        assertEquals(25.00, pedido.getValor(), 0.01);
    }

    @Test
    void restaurarRecuperaObservacaoAnterior() {
        PedidoEmEdicao pedido = new PedidoEmEdicao("X-Burguer", 25.00, "sem cebola");
        MementoPedido  snap   = pedido.salvar();
        pedido.setObservacao("com tudo");
        pedido.restaurar(snap);
        assertEquals("sem cebola", pedido.getObservacao());
    }

    // -- Histórico (Caretaker) --------------------------------------------

    @Test
    void historicoArmazenaSnapshotCorretamente() {
        HistoricoPedido historico = new HistoricoPedido();
        PedidoEmEdicao  pedido    = new PedidoEmEdicao("X-Burguer", 25.00, "normal");
        historico.salvar(pedido.salvar());
        assertEquals(1, historico.totalSalvos());
    }

    @Test
    void desfazerVazioLancaExcecao() {
        HistoricoPedido historico = new HistoricoPedido();
        assertThrows(IllegalStateException.class, historico::desfazer);
    }

    @Test
    void desfazerRetornaUltimoSnapshot() {
        HistoricoPedido historico = new HistoricoPedido();
        PedidoEmEdicao  pedido    = new PedidoEmEdicao("X-Burguer", 25.00, "normal");

        historico.salvar(pedido.salvar());
        pedido.setItem("X-Bacon");
        historico.salvar(pedido.salvar());

        MementoPedido ultimo = historico.desfazer();
        assertEquals("X-Bacon", ultimo.getItem());
    }
}