package Comportamentais.state;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StatePedidoTest {

    @Test
    void pedidoIniciaComoAguardando() {
        assertEquals("AGUARDANDO", new PedidoContext().getStatusAtual());
    }

    @Test
    void confirmarAguardandoMudaParaEmPreparo() {
        PedidoContext ctx = new PedidoContext();
        ctx.confirmar();
        assertEquals("EM_PREPARO", ctx.getStatusAtual());
    }

    @Test
    void prepararEmPreparoMudaParaPronto() {
        PedidoContext ctx = new PedidoContext();
        ctx.confirmar();
        ctx.preparar();
        assertEquals("PRONTO", ctx.getStatusAtual());
    }

    @Test
    void finalizarProntoMudaParaEntregue() {
        PedidoContext ctx = new PedidoContext();
        ctx.confirmar();
        ctx.preparar();
        ctx.finalizar();
        assertEquals("ENTREGUE", ctx.getStatusAtual());
    }

    @Test
    void fluxoCompletoPercorreTodosOsEstados() {
        PedidoContext ctx = new PedidoContext();
        assertEquals("AGUARDANDO", ctx.getStatusAtual());
        ctx.confirmar(); assertEquals("EM_PREPARO", ctx.getStatusAtual());
        ctx.preparar();  assertEquals("PRONTO",     ctx.getStatusAtual());
        ctx.finalizar(); assertEquals("ENTREGUE",   ctx.getStatusAtual());
    }

    @Test
    void prepararAguardandoNaoMudaEstado() {
        PedidoContext ctx = new PedidoContext();
        ctx.preparar();
        assertEquals("AGUARDANDO", ctx.getStatusAtual());
    }

    @Test
    void finalizarAguardandoNaoMudaEstado() {
        PedidoContext ctx = new PedidoContext();
        ctx.finalizar();
        assertEquals("AGUARDANDO", ctx.getStatusAtual());
    }

    @Test
    void confirmarEntregueNaoMudaEstado() {
        PedidoContext ctx = new PedidoContext();
        ctx.confirmar(); ctx.preparar(); ctx.finalizar();
        ctx.confirmar();
        assertEquals("ENTREGUE", ctx.getStatusAtual());
    }
}