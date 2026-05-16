package Estrutura.decorator;

public class ExtraOvo extends ExtraDecorator {

    private static final double PRECO_OVO = 2.00;

    public ExtraOvo( ILanche lanche ) {
        super(lanche);
    }

    @Override
    public String getDescricao() {
        return lanche.getDescricao() + ", ovo";
    }

    @Override
    public double getPreco() {
        return lanche.getPreco() + PRECO_OVO;
    }
}
