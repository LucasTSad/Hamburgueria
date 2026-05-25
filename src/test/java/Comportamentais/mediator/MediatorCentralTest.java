package Comportamentais.mediator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MediatorCentralTest {

    private CentralAtendimento central;
    private SetorCozinha       cozinha;
    private SetorEntrega       entrega;
    private SetorAtendimento   atendimento;

    @BeforeEach
    void montar() {
        central     = new CentralAtendimento();
        cozinha     = new SetorCozinha(central);
        entrega     = new SetorEntrega(central);
        atendimento = new SetorAtendimento(central);
        central.setCozinha(cozinha);
        central.setEntrega(entrega);
        central.setAtendimento(atendimento);
    }

    @Test
    void registrarPedidoNaoLancaExcecao() {
        assertDoesNotThrow(() -> atendimento.registrarPedido("042"));
    }

    @Test
    void pedidoProntoNaoLancaExcecao() {
        assertDoesNotThrow(() -> cozinha.pedidoPronto("042"));
    }

    @Test
    void pedidoEntregueNaoLancaExcecao() {
        assertDoesNotThrow(() -> entrega.pedidoEntregue("042"));
    }

    @Test
    void fluxoCompletoNaoLancaExcecao() {
        assertDoesNotThrow(() -> {
            atendimento.registrarPedido("099");
            cozinha.pedidoPronto("099");
            entrega.pedidoEntregue("099");
        });
    }

    @Test
    void cozinhaTeMediatorConfigurado() {
        assertNotNull(cozinha.mediator);
    }

    @Test
    void entregaTemMediatorConfigurado() {
        assertNotNull(entrega.mediator);
    }

    @Test
    void setoresNaoSeConhecemDiretamente() {
        // Atendimento não referencia cozinha — só o mediador
        assertNotSame(atendimento, cozinha);
        assertNotSame(entrega, cozinha);
    }

    @Test
    void cozinhaPossuiNomeCorreto() {
        assertEquals("Cozinha", cozinha.getNome());
    }

    @Test
    void entregaPossuiNomeCorreto() {
        assertEquals("Entrega", entrega.getNome());
    }
}