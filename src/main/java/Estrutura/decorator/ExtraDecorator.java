package Estrutura.decorator;

public class ExtraDecorator implements ILanche {

    protected ILanche lanche;

    public ExtraDecorator(ILanche lanche) {
        this.lanche = lanche;
    }

    @Override
    public String getDescricao() {
        return lanche.getDescricao();
    }

    @Override
    public double getPreco() {
        return lanche.getPreco();
    }
}
