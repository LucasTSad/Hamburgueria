package Estrutura.adapter;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AdapterPagamentoLegadoTest {

    // -- Contrato da interface moderna ------------------------------------

    @Test
    void adapterImplementaIProcessadorPagamento() {
        IProcessadorPagamento adapter =
                new AdapterPagamentoLegado(new PagamentoLegado());
        assertInstanceOf(IProcessadorPagamento.class, adapter);
    }

    @Test
    void pagamentoComValorPositivoRetornaTrue() {
        IProcessadorPagamento adapter =
                new AdapterPagamentoLegado(new PagamentoLegado());
        assertTrue(adapter.processarPagamento("João", 28.90));
    }

    @Test
    void pagamentoComValorZeroRetornaFalse() {
        IProcessadorPagamento adapter =
                new AdapterPagamentoLegado(new PagamentoLegado());
        assertFalse(adapter.processarPagamento("João", 0.0));
    }

    // -- Conversão de tipos -----------------------------------------------

    @Test
    void valorEmReaisEhConvertidoParaCentavosCorretamente() {
        // 28.90 → 2890 centavos → legado retorna 0 (sucesso)
        IProcessadorPagamento adapter =
                new AdapterPagamentoLegado(new PagamentoLegado());
        assertTrue(adapter.processarPagamento("Maria", 28.90));
    }

    // -- Forma de pagamento -----------------------------------------------

    @Test
    void getFormaPagamentoNaoRetornaNulo() {
        IProcessadorPagamento adapter =
                new AdapterPagamentoLegado(new PagamentoLegado());
        assertNotNull(adapter.getFormaPagamento());
    }

    @Test
    void getFormaPagamentoContemIdentificadorDoSistemaLegado() {
        IProcessadorPagamento adapter =
                new AdapterPagamentoLegado(new PagamentoLegado());
        assertTrue(adapter.getFormaPagamento().contains("TERMINAL_LEGACY_v1"));
    }
}