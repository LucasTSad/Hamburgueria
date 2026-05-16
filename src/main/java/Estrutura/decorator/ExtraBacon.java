package Estrutura.decorator;

public class ExtraBacon extends ExtraDecorator {

    private static final double PRECO_BACON = 4.00;

    public ExtraBacon( ILanche lanche ) {
        super(lanche);
    }

    @Override
    public String getDescricao() {
        return lanche.getDescricao() + ", bacon";
    }

    @Override
    public double getPreco() {
        return lanche.getPreco() + PRECO_BACON;
    }
}
