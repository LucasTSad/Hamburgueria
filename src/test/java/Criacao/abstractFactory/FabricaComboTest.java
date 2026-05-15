package Criacao.abstractFactory;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FabricaComboTest {

    // -- Combo Infantil ---------------------------------------------------

    @Test
    void comboInfantilCriaBebidaNaoNula() {
        FabricaCombo fabrica = new FabricaComboInfantil();
        assertNotNull(fabrica.criarBebida());
    }

    @Test
    void comboInfantilCriaAcompanhamentoNaoNulo() {
        FabricaCombo fabrica = new FabricaComboInfantil();
        assertNotNull(fabrica.criarAcompanhamento());
    }

    @Test
    void comboInfantilBebidaTemPrecoPositivo() {
        Bebida bebida = new FabricaComboInfantil().criarBebida();
        assertTrue(bebida.getPreco() > 0);
    }

    @Test
    void comboInfantilAcompanhamentoTemDescricaoNaoVazia() {
        Acompanhamento a = new FabricaComboInfantil().criarAcompanhamento();
        assertFalse(a.getDescricao().isEmpty());
    }

    // -- Combo Premium ----------------------------------------------------

    @Test
    void comboPremiumCriaBebidaNaoNula() {
        FabricaCombo fabrica = new FabricaComboPremium();
        assertNotNull(fabrica.criarBebida());
    }

    @Test
    void comboPremiumCriaAcompanhamentoNaoNulo() {
        FabricaCombo fabrica = new FabricaComboPremium();
        assertNotNull(fabrica.criarAcompanhamento());
    }

    @Test
    void comboPremiumBebidaTemPrecoMaiorQueComboInfantil() {
        double precoPremium   = new FabricaComboPremium().criarBebida().getPreco();
        double precoInfantil  = new FabricaComboInfantil().criarBebida().getPreco();
        assertTrue(precoPremium > precoInfantil);
    }

    // -- Polimorfismo -----------------------------------------------------

    @Test
    void fabricasProduzemTiposDiferentesDeBebidasParaMesmaInterface() {
        Bebida infantil = new FabricaComboInfantil().criarBebida();
        Bebida premium  = new FabricaComboPremium().criarBebida();
        assertNotEquals(infantil.getDescricao(), premium.getDescricao());
    }

    @Test
    void fabricasProduzemTiposDiferentesDeAcompanhamentosParaMesmaInterface() {
        Acompanhamento infantil = new FabricaComboInfantil().criarAcompanhamento();
        Acompanhamento premium  = new FabricaComboPremium().criarAcompanhamento();
        assertNotEquals(infantil.getDescricao(), premium.getDescricao());
    }
}