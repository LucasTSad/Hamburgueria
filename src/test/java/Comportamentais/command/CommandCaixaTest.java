package Comportamentais.command;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CommandCaixaTest {

    private Caixinha            caixa;
    private GerenciadorComandos gerenciador;

    @BeforeEach
    void setUp() {
        caixa       = new Caixinha();
        gerenciador = new GerenciadorComandos();
    }

    @Test
    void executarAbrirCaixaAbreOCaixa() {
        gerenciador.executar(new ComandoAbrirCaixa(caixa));
        assertTrue(caixa.isAberto());
    }

    @Test
    void executarRegistrarVendaAcumulaTotal() {
        gerenciador.executar(new ComandoRegistrarVenda(caixa, 28.90));
        assertEquals(28.90, caixa.getTotalVendas(), 0.01);
    }

    @Test
    void duasVendasAcumulamTotalCorretamente() {
        gerenciador.executar(new ComandoRegistrarVenda(caixa, 28.90));
        gerenciador.executar(new ComandoRegistrarVenda(caixa, 32.00));
        assertEquals(60.90, caixa.getTotalVendas(), 0.01);
    }

    @Test
    void executarAdicionaComandoAoHistorico() {
        gerenciador.executar(new ComandoAbrirCaixa(caixa));
        assertEquals(1, gerenciador.totalNoHistorico());
    }

    @Test
    void desfazerUltimoRemoveDoHistorico() {
        gerenciador.executar(new ComandoAbrirCaixa(caixa));
        gerenciador.desfazerUltimo();
        assertEquals(0, gerenciador.totalNoHistorico());
    }

    @Test
    void desfazerAbrirCaixaFechaOCaixa() {
        gerenciador.executar(new ComandoAbrirCaixa(caixa));
        gerenciador.desfazerUltimo();
        assertFalse(caixa.isAberto());
    }

    @Test
    void desfazerVendaEstornaTotalCorretamente() {
        gerenciador.executar(new ComandoRegistrarVenda(caixa, 50.00));
        gerenciador.desfazerUltimo();
        assertEquals(0.00, caixa.getTotalVendas(), 0.01);
    }

    @Test
    void desfazerSemHistoricoNaoLancaExcecao() {
        assertDoesNotThrow(() -> gerenciador.desfazerUltimo());
    }

    @Test
    void desfazerRespeiraOrdemLIFO() {
        gerenciador.executar(new ComandoRegistrarVenda(caixa, 10.00));
        gerenciador.executar(new ComandoRegistrarVenda(caixa, 20.00));
        gerenciador.desfazerUltimo(); // desfaz 20.00
        assertEquals(10.00, caixa.getTotalVendas(), 0.01);
    }
}