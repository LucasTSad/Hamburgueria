package Comportamentais.interpreter;

public class ParserCupom {

    public static IExpressao parse(String cupom) {
        if (cupom == null || cupom.isBlank())
            throw new IllegalArgumentException("Cupom inválido.");

        String upper = cupom.trim().toUpperCase();

        if (upper.equals("FRETE0"))       return new ExpressaoFreteGratis();
        if (upper.equals("DESCONTO10"))   return new ExpressaoDesconto(10);
        if (upper.equals("DESCONTO15"))   return new ExpressaoDesconto(15);
        if (upper.equals("DESCONTO20"))   return new ExpressaoDesconto(20);
        if (upper.equals("MELHOR"))
            return new ExpressaoOuCupom(new ExpressaoDesconto(10), new ExpressaoFreteGratis());

        throw new IllegalArgumentException("Cupom não reconhecido: " + cupom);
    }
}