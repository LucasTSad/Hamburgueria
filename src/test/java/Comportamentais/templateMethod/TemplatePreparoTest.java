package Comportamentais.templateMethod;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TemplatePreparoTest {

    @Test
    void prepararClassicoNaoLancaExcecao() {
        assertDoesNotThrow(() -> new PreparoClassico().preparar());
    }

    @Test
    void prepararVeganoNaoLancaExcecao() {
        assertDoesNotThrow(() -> new PreparoVegano().preparar());
    }

    @Test
    void prepararFrangoNaoLancaExcecao() {
        assertDoesNotThrow(() -> new PreparoFrango().preparar());
    }

    @Test
    void classicoEhInstanciaDePreparoLanche() {
        assertInstanceOf(PreparoLanche.class, new PreparoClassico());
    }

    @Test
    void veganoEhInstanciaDePreparoLanche() {
        assertInstanceOf(PreparoLanche.class, new PreparoVegano());
    }

    @Test
    void frangoEhInstanciaDePreparoLanche() {
        assertInstanceOf(PreparoLanche.class, new PreparoFrango());
    }

    @Test
    void metodoPrepararExisteNaClasseAbstrata() throws NoSuchMethodException {
        var metodo = PreparoLanche.class.getMethod("preparar");
        assertTrue(java.lang.reflect.Modifier.isFinal(metodo.getModifiers()));
    }
}