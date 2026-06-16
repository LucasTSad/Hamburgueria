package Comportamentais.interpreter;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InterpreterCupomTest {

    private final ContextoCupom ctx = new ContextoCupom(100.00, 8.00);

    @Test
    void expressaoDescontoDezRetornaDezPorCento() {
        assertEquals(10.00, new ExpressaoDesconto(10).interpretar(ctx), 0.01);
    }

    @Test
    void expressaoDescontoVinteRetornaVintePorCento() {
        assertEquals(20.00, new ExpressaoDesconto(20).interpretar(ctx), 0.01);
    }

    @Test
    void expressaoFreteGratisRetornaTaxaEntrega() {
        assertEquals(8.00, new ExpressaoFreteGratis().interpretar(ctx), 0.01);
    }

    @Test
    void expressaoOuRetornaMaiorDesconto() {
        IExpressao ou = new ExpressaoOuCupom(
                new ExpressaoDesconto(10),
                new ExpressaoFreteGratis());
        assertEquals(10.00, ou.interpretar(ctx), 0.01);
    }

    @Test
    void expressaoOuRetornaFreteQuandoFreteEhMaior() {
        ContextoCupom ctxFreteAlto = new ContextoCupom(50.00, 30.00);
        IExpressao ou = new ExpressaoOuCupom(
                new ExpressaoDesconto(10),
                new ExpressaoFreteGratis());
        assertEquals(30.00, ou.interpretar(ctxFreteAlto), 0.01);
    }

    @Test
    void parseFrete0RetornaExpressaoFreteGratis() {
        IExpressao exp = ParserCupom.parse("FRETE0");
        assertEquals(8.00, exp.interpretar(ctx), 0.01);
    }

    @Test
    void parseDesconto10RetornaExpressaoCorreta() {
        IExpressao exp = ParserCupom.parse("DESCONTO10");
        assertEquals(10.00, exp.interpretar(ctx), 0.01);
    }

    @Test
    void parseMelhorRetornaOuExpressao() {
        IExpressao exp = ParserCupom.parse("MELHOR");
        assertEquals(10.00, exp.interpretar(ctx), 0.01);
    }

    @Test
    void parseCupomInvalidoLancaExcecao() {
        assertThrows(IllegalArgumentException.class,
                () -> ParserCupom.parse("INVALIDO"));
    }

    @Test
    void parseNuloLancaExcecao() {
        assertThrows(IllegalArgumentException.class,
                () -> ParserCupom.parse(null));
    }

    @Test
    void parseCaseInsensitive() {
        assertDoesNotThrow(() -> ParserCupom.parse("frete0"));
    }
}