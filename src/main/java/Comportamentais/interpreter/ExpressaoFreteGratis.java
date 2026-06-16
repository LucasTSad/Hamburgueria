package Comportamentais.interpreter;

public class ExpressaoFreteGratis implements IExpressao {

    @Override
    public double interpretar(ContextoCupom ctx) {
        return ctx.getTaxaEntrega();
    }
}