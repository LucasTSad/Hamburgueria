package Estrutura.flyweight;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FlyweightIngredienteTest {

    @BeforeEach
    void limparCache() {
        FabricaIngrediente.limparCache();
    }

    // -- Criação e cache --------------------------------------------------

    @Test
    void primeiraChamadaCriaIngrediente() {
        FabricaIngrediente.obter("queijo", 80, "lactose");
        assertEquals(1, FabricaIngrediente.totalCriados());
    }

    @Test
    void segundaChamadaComMesmoNomeNaoCriaNovoObjeto() {
        DadosIngrediente a = FabricaIngrediente.obter("queijo", 80, "lactose");
        DadosIngrediente b = FabricaIngrediente.obter("queijo", 80, "lactose");
        assertSame(a, b);
    }

    @Test
    void ingredientesDiferentesGeramDoisObjetosNocache() {
        FabricaIngrediente.obter("queijo", 80, "lactose");
        FabricaIngrediente.obter("bacon",  120, "nenhum");
        assertEquals(2, FabricaIngrediente.totalCriados());
    }

    @Test
    void cacheIniciaVazioAposLimpeza() {
        assertEquals(0, FabricaIngrediente.totalCriados());
    }

    // -- Dados do flyweight -----------------------------------------------

    @Test
    void dadosIngredienteArmazenaNomeCorretamente() {
        DadosIngrediente d = FabricaIngrediente.obter("alface", 5, "nenhum");
        assertEquals("alface", d.getNome());
    }

    @Test
    void dadosIngredienteArmazenaCaloriasCorretamente() {
        DadosIngrediente d = FabricaIngrediente.obter("alface", 5, "nenhum");
        assertEquals(5, d.getCalorias());
    }

    @Test
    void dadosIngredienteArmazenaAlergenos() {
        DadosIngrediente d = FabricaIngrediente.obter("pao-brioche", 220, "gluten,lactose");
        assertEquals("gluten,lactose", d.getAlergenos());
    }

    // -- Estado extrínseco (contexto) -------------------------------------

    @Test
    void ingredienteNoLancheArmazenaQuantidadeCorretamente() {
        DadosIngrediente dados = FabricaIngrediente.obter("queijo", 80, "lactose");
        IngredienteNoLanche uso = new IngredienteNoLanche(dados, 2, "bem derretido");
        assertEquals(2, uso.getQuantidade());
    }

    @Test
    void ingredienteNoLancheArmazenaObservacaoCorretamente() {
        DadosIngrediente dados = FabricaIngrediente.obter("queijo", 80, "lactose");
        IngredienteNoLanche uso = new IngredienteNoLanche(dados, 1, "sem sal");
        assertEquals("sem sal", uso.getObservacao());
    }

    @Test
    void doisLanchesCompartilhamMesmoFlyweight() {
        DadosIngrediente queijo = FabricaIngrediente.obter("queijo", 80, "lactose");
        IngredienteNoLanche usoLanche1 = new IngredienteNoLanche(queijo, 1, "normal");
        IngredienteNoLanche usoLanche2 = new IngredienteNoLanche(queijo, 2, "extra");
        assertSame(usoLanche1.getDados(), usoLanche2.getDados());
    }
}