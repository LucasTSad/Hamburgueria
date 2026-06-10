package Comportamentais.strategy;

public class DescontoPercentual implements IEstrategiaDesconto {

    private double percentual;

    public DescontoPercentual(double percentual) {
        if (percentual < 0 || percentual > 100)
            throw new IllegalArgumentException("Percentual inválido: " + percentual);
        this.percentual = percentual;
    }

    @Override public double calcularDesconto(double v) { return v * (percentual / 100); }
    @Override public String getDescricao()             { return percentual + "% de desconto"; }
}