package Comportamentais.interpreter;

public class ExpressaoDesconto implements IExpressao {

    private double percentual;

    public ExpressaoDesconto(double percentual) { this.percentual = percentual; }

    @Override
    public double interpretar(ContextoCupom ctx) {
        return ctx.getValorPedido() * (percentual / 100);
    }
}