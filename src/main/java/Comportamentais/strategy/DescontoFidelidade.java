package Comportamentais.strategy;

public class DescontoFidelidade implements IEstrategiaDesconto {

    private static final double DESCONTO_FIXO = 5.00;

    @Override
    public double calcularDesconto(double v) { return Math.min(v, DESCONTO_FIXO); }

    @Override
    public String getDescricao() { return "Fidelidade (R$ 5,00 fixo)"; }
}