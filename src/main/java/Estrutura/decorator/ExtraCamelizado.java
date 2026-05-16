package Estrutura.decorator;

public class ExtraCamelizado extends ExtraDecorator {

    private static final double PRECO_CAMELIZADO = 3.00;

    public ExtraCamelizado( ILanche lanche ) {
        super(lanche);
    }

    @Override
    public String getDescricao() {
        return lanche.getDescricao() + ", cebola caramelizada";
    }

    @Override
    public double getPreco() {
        return lanche.getPreco() + PRECO_CAMELIZADO;
    }
}
