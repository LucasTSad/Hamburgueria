package Comportamentais.strategy;

public class DescontoNenhum implements IEstrategiaDesconto {
    @Override public double calcularDesconto(double v) { return 0; }
    @Override public String getDescricao()             { return "Sem desconto"; }
}