package Estrutura.proxy;

import Criacao.singleton.ConfiguracaoHamburgueria;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProxyPainelAdminTest {

    @BeforeEach
    void resetarGerente() {
        ConfiguracaoHamburgueria.getInstance().setGerenteLogado(null);
    }

    // -- Acesso negado (sem gerente) --------------------------------------

    @Test
    void alterarPrecoSemGerenteLancaSecurityException() {
        IPainelAdmin painel = new ProxyPainelAdmin();
        assertThrows(SecurityException.class,
                () -> painel.alterarPreco("X-Burguer", 30.00));
    }

    @Test
    void fecharCaixaSemGerenteLancaSecurityException() {
        IPainelAdmin painel = new ProxyPainelAdmin();
        assertThrows(SecurityException.class, painel::fecharCaixa);
    }

    @Test
    void gerarRelatorioSemGerenteLancaSecurityException() {
        IPainelAdmin painel = new ProxyPainelAdmin();
        assertThrows(SecurityException.class, painel::gerarRelatorio);
    }

    @Test
    void gerenteEmBrancoTambemNegaAcesso() {
        ConfiguracaoHamburgueria.getInstance().setGerenteLogado("   ");
        IPainelAdmin painel = new ProxyPainelAdmin();
        assertThrows(SecurityException.class, painel::fecharCaixa);
    }

    // -- Acesso permitido (com gerente) -----------------------------------

    @Test
    void alterarPrecoComGerenteLogadoNaoLancaExcecao() {
        ConfiguracaoHamburgueria.getInstance().setGerenteLogado("Carlos");
        IPainelAdmin painel = new ProxyPainelAdmin();
        assertDoesNotThrow(() -> painel.alterarPreco("X-Burguer", 30.00));
    }

    @Test
    void fecharCaixaComGerenteLogadoNaoLancaExcecao() {
        ConfiguracaoHamburgueria.getInstance().setGerenteLogado("Carlos");
        IPainelAdmin painel = new ProxyPainelAdmin();
        assertDoesNotThrow(painel::fecharCaixa);
    }

    @Test
    void gerarRelatorioComGerenteLogadoNaoLancaExcecao() {
        ConfiguracaoHamburgueria.getInstance().setGerenteLogado("Ana");
        IPainelAdmin painel = new ProxyPainelAdmin();
        assertDoesNotThrow(painel::gerarRelatorio);
    }

    // -- Proxy respeita a interface ---------------------------------------

    @Test
    void proxyImplementaIPainelAdmin() {
        assertInstanceOf(IPainelAdmin.class, new ProxyPainelAdmin());
    }

    @Test
    void trocarGerenteLiberaAcessoAntesNegado() {
        IPainelAdmin painel = new ProxyPainelAdmin();
        assertThrows(SecurityException.class, painel::fecharCaixa);

        ConfiguracaoHamburgueria.getInstance().setGerenteLogado("Carlos");
        assertDoesNotThrow(painel::fecharCaixa);
    }
}