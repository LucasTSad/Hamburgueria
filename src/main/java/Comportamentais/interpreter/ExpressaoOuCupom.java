package Comportamentais.interpreter;

public class ExpressaoOuCupom implements IExpressao {

    private IExpressao esquerda;
    private IExpressao direita;

    public ExpressaoOuCupom(IExpressao esquerda, IExpressao direita) {
        this.esquerda = esquerda;
        this.direita  = direita;
    }

    @Override
    public double interpretar(ContextoCupom ctx) {
        return Math.max(esquerda.interpretar(ctx), direita.interpretar(ctx));
    }
}