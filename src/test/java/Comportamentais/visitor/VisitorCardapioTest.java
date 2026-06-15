package Comportamentais.visitor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class VisitorCardapioTest {

    private List<IElementoCardapio> cardapio;

    @BeforeEach
    void montarCardapio() {
        cardapio = List.of(
                new ItemVisitavel("X-Burguer",  25.00, 650),
                new ItemVisitavel("X-Salada",   22.00, 420),
                new ComboVisitavel("Combo Kids", 35.00, 800, "lanche + suco + batata"),
                new ItemVisitavel("Brownie",     12.00, 380)
        );
    }

    @Test
    void visitanteCalculaTotalCorretamente() {
        VisitanteCalculoTotal visitante = new VisitanteCalculoTotal();
        cardapio.forEach(e -> e.aceitar(visitante));
        assertEquals(94.00, visitante.getTotal(), 0.01);
    }

    @Test
    void cardapioVazioRetornaTotalZero() {
        VisitanteCalculoTotal visitante = new VisitanteCalculoTotal();
        assertEquals(0.00, visitante.getTotal(), 0.01);
    }

    @Test
    void visitarApenasItensSimples() {
        VisitanteCalculoTotal visitante = new VisitanteCalculoTotal();
        new ItemVisitavel("X-Burguer", 25.00, 650).aceitar(visitante);
        assertEquals(25.00, visitante.getTotal(), 0.01);
    }

    @Test
    void auditoriaIdentificaItensAcimaDoLimite() {
        VisitanteAuditoriaCaloria auditoria = new VisitanteAuditoriaCaloria(500);
        cardapio.forEach(e -> e.aceitar(auditoria));
        assertEquals(2, auditoria.totalAltosCalorias());
    }

    @Test
    void auditoriaRetornaNomesCorretosDosItensAltos() {
        VisitanteAuditoriaCaloria auditoria = new VisitanteAuditoriaCaloria(500);
        cardapio.forEach(e -> e.aceitar(auditoria));
        assertTrue(auditoria.getItensAltosCalorias().contains("X-Burguer"));
        assertTrue(auditoria.getItensAltosCalorias().contains("Combo Kids"));
    }

    @Test
    void auditoriaComLimiteAltoNaoIdentificaNinguem() {
        VisitanteAuditoriaCaloria auditoria = new VisitanteAuditoriaCaloria(1000);
        cardapio.forEach(e -> e.aceitar(auditoria));
        assertEquals(0, auditoria.totalAltosCalorias());
    }

    @Test
    void itemEComboAceitamMesmoVisitante() {
        VisitanteCalculoTotal visitante = new VisitanteCalculoTotal();
        assertDoesNotThrow(() -> {
            new ItemVisitavel("X-Burguer", 25.00, 650).aceitar(visitante);
            new ComboVisitavel("Combo", 35.00, 800, "desc").aceitar(visitante);
        });
    }
}