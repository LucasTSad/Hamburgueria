package Estrutura.facade;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FacadeCaixaTest {

    // -- Fluxo completo ---------------------------------------------------

    @Test
    void atendimentoCompletoRetornaTrue() {
        Caixa caixa = new Caixa();
        assertTrue(caixa.atender("João", "X-Burguer", 28.90, "cartão"));
    }

    @Test
    void atendimentoComDiferentesFormasDePagamentoRetornaTrue() {
        Caixa caixa = new Caixa();
        assertTrue(caixa.atender("Maria", "X-Bacon", 32.90, "pix"));
        assertTrue(caixa.atender("Carlos", "X-Tudo", 39.90, "dinheiro"));
    }

    @Test
    void atendimentoComValorZeroRetornaTrue() {
        Caixa caixa = new Caixa();
        // cortesia da casa — valor zero ainda é atendimento válido
        assertTrue(caixa.atender("VIP", "Água", 0.00, "cortesia"));
    }

    // -- Subsistemas isolados --------------------------------------------

    @Test
    void subsistemaPedidoRegistraENaoRetornaNulo() {
        SubsistemaPedido subsistema = new SubsistemaPedido();
        String numero = subsistema.registrar("Ana", "X-Salada");
        assertNotNull(numero);
    }

    @Test
    void subsistemaPedidoRegistraERetornaNumeroNaoVazio() {
        SubsistemaPedido subsistema = new SubsistemaPedido();
        String numero = subsistema.registrar("Ana", "X-Salada");
        assertFalse(numero.isEmpty());
    }

    @Test
    void subsistemaPagamentoAprovaPagamentoPositivo() {
        SubsistemaPagamento subsistema = new SubsistemaPagamento();
        assertTrue(subsistema.cobrar("João", 28.90, "pix"));
    }

    @Test
    void subsistemaCozinhaNaoLancaExcecao() {
        SubsistemaCozinha subsistema = new SubsistemaCozinha();
        assertDoesNotThrow(() -> subsistema.enviarParaProducao("001", "X-Burguer"));
    }

    @Test
    void subsistemaNotaFiscalNaoLancaExcecao() {
        SubsistemaNotaFiscal subsistema = new SubsistemaNotaFiscal();
        assertDoesNotThrow(() -> subsistema.emitir("001", "João", 28.90));
    }
}