package Estrutura.composite;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CompositeCardapioTest {

    // -- ItemCardapio -----------------------------------------------------

    @Test
    void itemRetornaNomeCorreto() {
        ItemCardapio item = new ItemCardapio("X-Bacon", 32.90);
        assertEquals("X-Bacon", item.getNome());
    }

    @Test
    void itemRetornaPrecoCorreto() {
        ItemCardapio item = new ItemCardapio("X-Bacon", 32.90);
        assertEquals(32.90, item.getPreco(), 0.01);
    }

    @Test
    void itemComPrecoZeroEhValido() {
        assertDoesNotThrow(() -> new ItemCardapio("Agua", 0.0));
    }

    @Test
    void itemComNomeNuloLancaExcecao() {
        assertThrows(IllegalArgumentException.class,
                () -> new ItemCardapio(null, 10.00));
    }

    @Test
    void itemComPrecoNegativoLancaExcecao() {
        assertThrows(IllegalArgumentException.class,
                () -> new ItemCardapio("X-Salada", -1.00));
    }

    // -- CategoriaCardapio vazia ------------------------------------------

    @Test
    void categoriaVaziaTemPrecoZero() {
        CategoriaCardapio cat = new CategoriaCardapio("Lanches");
        assertEquals(0.0, cat.getPreco(), 0.01);
    }

    @Test
    void categoriaVaziaTemZeroFilhos() {
        CategoriaCardapio cat = new CategoriaCardapio("Lanches");
        assertEquals(0, cat.totalFilhos());
    }

    @Test
    void categoriaNomeNuloLancaExcecao() {
        assertThrows(IllegalArgumentException.class,
                () -> new CategoriaCardapio(null));
    }

    // -- Categoria com itens ----------------------------------------------

    @Test
    void categoriaComUmItemRetornaPrecoDoItem() {
        CategoriaCardapio cat = new CategoriaCardapio("Bebidas");
        cat.adicionar(new ItemCardapio("Coca-Cola", 7.00));
        assertEquals(7.00, cat.getPreco(), 0.01);
    }

    @Test
    void categoriaComDoisItensSomaPrecos() {
        CategoriaCardapio cat = new CategoriaCardapio("Bebidas");
        cat.adicionar(new ItemCardapio("Coca-Cola", 7.00));
        cat.adicionar(new ItemCardapio("Suco", 8.00));
        assertEquals(15.00, cat.getPreco(), 0.01);
    }

    @Test
    void adicionarItemAumentaContagem() {
        CategoriaCardapio cat = new CategoriaCardapio("Lanches");
        cat.adicionar(new ItemCardapio("X-Burguer", 25.00));
        assertEquals(1, cat.totalFilhos());
    }

    @Test
    void removerItemDiminuiContagem() {
        CategoriaCardapio cat = new CategoriaCardapio("Lanches");
        ItemCardapio item = new ItemCardapio("X-Burguer", 25.00);
        cat.adicionar(item);
        cat.remover(item);
        assertEquals(0, cat.totalFilhos());
    }

    // -- Composição recursiva ---------------------------------------------

    @Test
    void categoriaComSubcategoriaSomaPrecosRecursivamente() {
        CategoriaCardapio raiz    = new CategoriaCardapio("Cardápio");
        CategoriaCardapio lanches = new CategoriaCardapio("Lanches");
        lanches.adicionar(new ItemCardapio("X-Burguer", 25.00));
        lanches.adicionar(new ItemCardapio("X-Bacon",   32.00));
        raiz.adicionar(new ItemCardapio("Sobremesa", 12.00));
        raiz.adicionar(lanches);
        assertEquals(69.00, raiz.getPreco(), 0.01);
    }

    @Test
    void itemECategoriaSaoTratadosComoMesmaInterface() {
        IComponenteCardapio item = new ItemCardapio("X-Salada", 22.00);
        IComponenteCardapio cat  = new CategoriaCardapio("Lanches");
        assertNotNull(item.getNome());
        assertNotNull(cat.getNome());
    }
}