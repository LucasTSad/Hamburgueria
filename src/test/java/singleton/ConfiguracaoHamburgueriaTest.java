package singleton;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ConfiguracaoHamburgueriaTest {
    // -- Instância única --------------------------------------------------

    @Test
    void getInstanceRetornaSempreAMesmaReferencia() {
        ConfiguracaoHamburgueria a = ConfiguracaoHamburgueria.getInstance();
        ConfiguracaoHamburgueria b = ConfiguracaoHamburgueria.getInstance();
        assertSame(a, b);
    }

    @Test
    void instanciaNaoEhNula() {
        assertNotNull(ConfiguracaoHamburgueria.getInstance());
    }

    // -- Nome do estabelecimento ------------------------------------------

    @Test
    void setNomeEstabelecimentoAlteraValorCorretamente() {
        ConfiguracaoHamburgueria config = ConfiguracaoHamburgueria.getInstance();
        config.setNomeEstabelecimento("BurgerGoF");
        assertEquals("BurgerGoF", config.getNomeEstabelecimento());
    }

    @Test
    void alteracaoNomeEhVisivelEmOutraReferencia() {
        ConfiguracaoHamburgueria.getInstance().setNomeEstabelecimento("BurgerGoF");
        ConfiguracaoHamburgueria outra = ConfiguracaoHamburgueria.getInstance();
        assertEquals("BurgerGoF", outra.getNomeEstabelecimento());
    }

    // -- Taxa de entrega --------------------------------------------------

    @Test
    void setTaxaEntregaArmazenaValorCorreto() {
        ConfiguracaoHamburgueria.getInstance().setTaxaEntrega(5.99);
        assertEquals(5.99, ConfiguracaoHamburgueria.getInstance().getTaxaEntrega());
    }

    @Test
    void taxaEntregaZeroEhValida() {
        ConfiguracaoHamburgueria.getInstance().setTaxaEntrega(0.0);
        assertEquals(0.0, ConfiguracaoHamburgueria.getInstance().getTaxaEntrega());
    }

    // -- Horário de funcionamento -----------------------------------------

    @Test
    void setHorarioAberturaArmazenaValorCorreto() {
        ConfiguracaoHamburgueria.getInstance().setHorarioAbertura("11:00");
        assertEquals("11:00", ConfiguracaoHamburgueria.getInstance().getHorarioAbertura());
    }

    @Test
    void setHorarioFechamentoArmazenaValorCorreto() {
        ConfiguracaoHamburgueria.getInstance().setHorarioFechamento("23:00");
        assertEquals("23:00", ConfiguracaoHamburgueria.getInstance().getHorarioFechamento());
    }

    // -- Gerente logado ---------------------------------------------------

    @Test
    void setGerenteLogadoArmazenaValorCorreto() {
        ConfiguracaoHamburgueria.getInstance().setGerenteLogado("Carlos");
        assertEquals("Carlos", ConfiguracaoHamburgueria.getInstance().getGerenteLogado());
    }

    @Test
    void trocarGerenteLogadoSubstituiValorAnterior() {
        ConfiguracaoHamburgueria config = ConfiguracaoHamburgueria.getInstance();
        config.setGerenteLogado("Carlos");
        config.setGerenteLogado("Ana");
        assertEquals("Ana", config.getGerenteLogado());
    }
}