package Estrutura.decorator;

public class ExtraQueijo extends ExtraDecorator {

    private static final double PRECO_QUEIJO = 2.50;

    public ExtraQueijo( ILanche lanche ) {
        super(lanche);
    }

    @Override
    public String getDescricao() {
        return lanche.getDescricao() + ", queijo";
    }

    @Override
    public double getPreco() {
        return lanche.getPreco() + PRECO_QUEIJO;
    }
}
