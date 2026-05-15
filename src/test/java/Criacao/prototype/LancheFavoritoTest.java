package Criacao.prototype;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class LancheFavoritoTest {

    private LancheFavorito criarFavorito() {
        return new LancheFavorito(
                "MeuBurger", "brioche", "blend 180g",
                Arrays.asList("queijo", "alface", "tomate"),
                "especial", 28.90
        );
    }

    // -- Clone básico -----------------------------------------------------

    @Test
    void cloneNaoRetornaOMesmoObjeto() {
        LancheFavorito original = criarFavorito();
        assertNotSame(original, original.clone());
    }

    @Test
    void cloneMantemNomeDoOriginal() {
        LancheFavorito clone = criarFavorito().clone();
        assertEquals("MeuBurger", clone.getNome());
    }

    @Test
    void cloneMantemCarneDoOriginal() {
        LancheFavorito clone = criarFavorito().clone();
        assertEquals("blend 180g", clone.getCarne());
    }

    @Test
    void cloneMantemPrecoDoOriginal() {
        LancheFavorito clone = criarFavorito().clone();
        assertEquals(28.90, clone.getPreco(), 0.01);
    }

    // -- Clone profundo (isolamento de lista) -----------------------------

    @Test
    void adicionarIngredienteNoCloneNaoAfetaOriginal() {
        LancheFavorito original = criarFavorito();
        LancheFavorito clone    = original.clone();
        clone.adicionarIngrediente("bacon");
        assertFalse(original.getIngredientes().contains("bacon"));
    }

    @Test
    void removerIngredienteDoCloneNaoAfetaOriginal() {
        LancheFavorito original = criarFavorito();
        LancheFavorito clone    = original.clone();
        clone.removerIngrediente("queijo");
        assertTrue(original.getIngredientes().contains("queijo"));
    }

    @Test
    void alterarMolhoNoCloneNaoAfetaOriginal() {
        LancheFavorito original = criarFavorito();
        LancheFavorito clone    = original.clone();
        clone.setMolho("barbecue");
        assertEquals("especial", original.getMolho());
    }

    // -- Personalização pós-clone -----------------------------------------

    @Test
    void clonePermiteAlterarNome() {
        LancheFavorito clone = criarFavorito().clone();
        clone.setNome("BurgerDaAna");
        assertEquals("BurgerDaAna", clone.getNome());
    }

    @Test
    void clonePermiteAlterarPreco() {
        LancheFavorito clone = criarFavorito().clone();
        clone.setPreco(34.90);
        assertEquals(34.90, clone.getPreco(), 0.01);
    }

    @Test
    void cloneContemOsMesmosIngredientesDoOriginal() {
        LancheFavorito original = criarFavorito();
        LancheFavorito clone    = original.clone();
        assertEquals(original.getIngredientes(), clone.getIngredientes());
    }
}