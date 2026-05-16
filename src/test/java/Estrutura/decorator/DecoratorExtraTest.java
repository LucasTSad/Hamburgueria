package Estrutura.decorator;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DecoratorExtraTest {

    // -- LancheSimples ----------------------------------------------------

    @Test
    void lancheSimplesRetornaDescricaoCorreta() {
        ILanche lanche = new LancheSimples("X-Burguer", 25.00);
        assertEquals("X-Burguer", lanche.getDescricao());
    }

    @Test
    void lancheSimplesRetornaPrecoCorreto() {
        ILanche lanche = new LancheSimples("X-Burguer", 25.00);
        assertEquals(25.00, lanche.getPreco(), 0.01);
    }

    @Test
    void lancheSimplesComNomeNuloLancaExcecao() {
        assertThrows(IllegalArgumentException.class,
                () -> new LancheSimples(null, 25.00));
    }

    @Test
    void lancheSimplesComPrecoNegativoLancaExcecao() {
        assertThrows(IllegalArgumentException.class,
                () -> new LancheSimples("X-Burguer", -1.00));
    }

    // -- Decoradores individuais ------------------------------------------

    @Test
    void extraBaconAdicionaPrecoCorretamente() {
        ILanche lanche = new ExtraBacon(new LancheSimples("X-Burguer", 25.00));
        assertEquals(29.00, lanche.getPreco(), 0.01);
    }

    @Test
    void extraBaconAdicionaDescricaoCorretamente() {
        ILanche lanche = new ExtraBacon(new LancheSimples("X-Burguer", 25.00));
        assertTrue(lanche.getDescricao().contains("bacon"));
    }

    @Test
    void extraQueijoAdicionaPrecoCorretamente() {
        ILanche lanche = new ExtraQueijo(new LancheSimples("X-Burguer", 25.00));
        assertEquals(27.50, lanche.getPreco(), 0.01);
    }

    @Test
    void extraCamelizadoAdicionaDescricaoCorretamente() {
        ILanche lanche = new ExtraCamelizado(new LancheSimples("X-Burguer", 25.00));
        assertTrue(lanche.getDescricao().contains("cebola caramelizada"));
    }

    @Test
    void extraOvoAdicionaPrecoCorretamente() {
        ILanche lanche = new ExtraOvo(new LancheSimples("X-Burguer", 25.00));
        assertEquals(27.00, lanche.getPreco(), 0.01);
    }

    // -- Encadeamento de decoradores --------------------------------------

    @Test
    void doisDecoradoreSomamPrecos() {
        ILanche lanche = new ExtraQueijo(
                new ExtraBacon(
                        new LancheSimples("X-Burguer", 25.00)));
        // 25 + 4 + 2.50 = 31.50
        assertEquals(31.50, lanche.getPreco(), 0.01);
    }

    @Test
    void tresDecoraderesEncadeadosSomamPrecos() {
        ILanche lanche = new ExtraOvo(
                new ExtraCamelizado(
                        new ExtraBacon(
                                new LancheSimples("X-Tudo", 30.00))));
        // 30 + 4 + 3 + 2 = 39.00
        assertEquals(39.00, lanche.getPreco(), 0.01);
    }

    @Test
    void tresDecoraderesEncadeadosAcumulamDescricao() {
        ILanche lanche = new ExtraOvo(
                new ExtraCamelizado(
                        new ExtraBacon(
                                new LancheSimples("X-Tudo", 30.00))));
        String desc = lanche.getDescricao();
        assertTrue(desc.contains("bacon"));
        assertTrue(desc.contains("cebola caramelizada"));
        assertTrue(desc.contains("ovo"));
    }

    @Test
    void decoradorNaoAlteraLancheOriginal() {
        ILanche base    = new LancheSimples("X-Burguer", 25.00);
        ILanche decorado = new ExtraBacon(base);
        assertEquals(25.00, base.getPreco(), 0.01);
        assertEquals(29.00, decorado.getPreco(), 0.01);
    }
}