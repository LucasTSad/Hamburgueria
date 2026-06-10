package Comportamentais.strategy;

public class DescontoHappyHour implements IEstrategiaDesconto {

    @Override
    public double calcularDesconto(double v) {
        return v > 50.00 ? v * 0.20 : 0;
    }

    @Override
    public String getDescricao() { return "Happy Hour (20% acima de R$ 50)"; }
}