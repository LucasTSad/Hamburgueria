package Comportamentais.iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class IteratorCardapioTest {

    private Cardapio cardapio;

    @BeforeEach
    void montarCardapio() {
        cardapio = new Cardapio();
        cardapio.adicionar(new ItemMenu("X-Burguer",  25.00, "lanche"));
        cardapio.adicionar(new ItemMenu("X-Bacon",    32.00, "lanche"));
        cardapio.adicionar(new ItemMenu("Coca-Cola",   7.00, "bebida"));
        cardapio.adicionar(new ItemMenu("Suco Laranja",8.00, "bebida"));
        cardapio.adicionar(new ItemMenu("Brownie",    12.00, "sobremesa"));
    }

    @Test
    void iteradorPercorreTodosOsItens() {
        IIteradorCardapio it = cardapio.iterador();
        int count = 0;
        while (it.temProximo()) { it.proximo(); count++; }
        assertEquals(5, count);
    }

    @Test
    void iteradorRetornaPrimeiroItemCorretamente() {
        IIteradorCardapio it = cardapio.iterador();
        assertEquals("X-Burguer", it.proximo().getNome());
    }

    @Test
    void cardapioVazioNaoTemProximo() {
        IIteradorCardapio it = new Cardapio().iterador();
        assertFalse(it.temProximo());
    }

    @Test
    void iteradorCategoriaRetornaApenasLanches() {
        IIteradorCardapio it = cardapio.iteradorPorCategoria("lanche");
        int count = 0;
        while (it.temProximo()) {
            assertEquals("lanche", it.proximo().getCategoria());
            count++;
        }
        assertEquals(2, count);
    }

    @Test
    void iteradorCategoriaRetornaApenasBebidasDoisItens() {
        IIteradorCardapio it = cardapio.iteradorPorCategoria("bebida");
        int count = 0;
        while (it.temProximo()) { it.proximo(); count++; }
        assertEquals(2, count);
    }

    @Test
    void iteradorCategoriaInexistenteNaoTemProximo() {
        IIteradorCardapio it = cardapio.iteradorPorCategoria("porcao");
        assertFalse(it.temProximo());
    }

    @Test
    void iteradorCategoriaEhCaseInsensitive() {
        IIteradorCardapio it = cardapio.iteradorPorCategoria("LANCHE");
        assertTrue(it.temProximo());
    }
}