package builder;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LancheBuilderTest {

    // -- Campos obrigatórios ----------------------------------------------

    @Test
    void buildSemNomeLancaExcecao() {
        assertThrows(IllegalArgumentException.class, () ->
                new LancheBuilder()
                        .setTipoPao("brioche")
                        .setCarne("blend 180g")
                        .build()
        );
    }

    @Test
    void buildSemTipoPaoLancaExcecao() {
        assertThrows(IllegalArgumentException.class, () ->
                new LancheBuilder()
                        .setNome("BurgerClássico")
                        .setCarne("blend 180g")
                        .build()
        );
    }

    @Test
    void buildSemCarneLancaExcecao() {
        assertThrows(IllegalArgumentException.class, () ->
                new LancheBuilder()
                        .setNome("BurgerClássico")
                        .setTipoPao("brioche")
                        .build()
        );
    }

    @Test
    void buildisCamposObrigatoriosRetornaLanche() {
        Lanche lanche = new LancheBuilder()
                .setNome("BurgerClássico")
                .setTipoPao("brioche")
                .setCarne("blend 180g")
                .build();
        assertNotNull(lanche);
    }

    // -- Campos básicos ---------------------------------------------------

    @Test
    void buildArmazenaNomedoLancheCorretamente() {
        Lanche lanche = new LancheBuilder()
                .setNome("FitBurger")
                .setTipoPao("integral")
                .setCarne("frango grelhado")
                .build();
        assertEquals("FitBurger", lanche.getNome());
    }

    @Test
    void buildArmazenaTipoPaoCorretamente() {
        Lanche lanche = new LancheBuilder()
                .setNome("X-Tudo")
                .setTipoPao("brioche")
                .setCarne("blend 180g")
                .build();
        assertEquals("brioche", lanche.getTipoPao());
    }

    @Test
    void buildArmazenaCarneCorretamente() {
        Lanche lanche = new LancheBuilder()
                .setNome("X-Tudo")
                .setTipoPao("brioche")
                .setCarne("blend 180g")
                .build();
        assertEquals("blend 180g", lanche.getCarne());
    }

    @Test
    void buildArmazenaPrecoCorretamente() {
        Lanche lanche = new LancheBuilder()
                .setNome("X-Tudo")
                .setTipoPao("brioche")
                .setCarne("blend 180g")
                .setPreco(28.90)
                .build();
        assertEquals(28.90, lanche.getPreco());
    }

    // -- Ingredientes opcionais -------------------------------------------

    @Test
    void semInvocarisQueijolancheNaoisQueijo() {
        Lanche lanche = new LancheBuilder()
                .setNome("Simples")
                .setTipoPao("pão de forma")
                .setCarne("hambúrguer")
                .build();
        assertFalse(lanche.isQueijo());
    }

    @Test
    void isQueijoAdicionaQueijAoLanche() {
        Lanche lanche = new LancheBuilder()
                .setNome("X-Queijo")
                .setTipoPao("brioche")
                .setCarne("blend")
                .isQueijo()
                .build();
        assertTrue(lanche.isQueijo());
    }

    @Test
    void isBaconAdicionaBaconAoLanche() {
        Lanche lanche = new LancheBuilder()
                .setNome("X-Bacon")
                .setTipoPao("brioche")
                .setCarne("blend")
                .isBacon()
                .build();
        assertTrue(lanche.isBacon());
    }

    @Test
    void semGlutenMarcaLancheisoSemGluten() {
        Lanche lanche = new LancheBuilder()
                .setNome("FitBurger")
                .setTipoPao("integral")
                .setCarne("frango")
                .semGluten()
                .build();
        assertTrue(lanche.isSemGluten());
    }

    @Test
    void lancheisTodosIngredientesEhConstruidoCorretamente() {
        Lanche lanche = new LancheBuilder()
                .setNome("X-Tudo")
                .setTipoPao("brioche")
                .setCarne("blend 180g")
                .isQueijo()
                .isBacon()
                .isAlface()
                .isTomate()
                .isCebola()
                .isPickles()
                .setMolho("especial")
                .setPreco(39.90)
                .build();

        assertTrue(lanche.isQueijo());
        assertTrue(lanche.isBacon());
        assertTrue(lanche.isAlface());
        assertTrue(lanche.isTomate());
        assertTrue(lanche.isCebola());
        assertTrue(lanche.isPickles());
        assertEquals("especial", lanche.getMolho());
    }

    // -- Encadeamento (fluent interface) ----------------------------------

    @Test
    void metodoSetNomeRetornaOProprioBuider() {
        LancheBuilder builder = new LancheBuilder();
        assertSame(builder, builder.setNome("X"));
    }

    @Test
    void metodoisQueijolRetornaOProprioBuider() {
        LancheBuilder builder = new LancheBuilder();
        assertSame(builder, builder.isQueijo());
    }
}