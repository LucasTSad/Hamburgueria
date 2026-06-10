package Comportamentais.strategy;

public class PedidoComDesconto {

    private double               valorOriginal;
    private IEstrategiaDesconto  estrategia;

    public PedidoComDesconto(double valorOriginal, IEstrategiaDesconto estrategia) {
        this.valorOriginal = valorOriginal;
        this.estrategia    = estrategia;
    }

    public void setEstrategia(IEstrategiaDesconto estrategia) {
        this.estrategia = estrategia;
    }

    public double getValorFinal() {
        return valorOriginal - estrategia.calcularDesconto(valorOriginal);
    }

    public double getDesconto()   { return estrategia.calcularDesconto(valorOriginal); }
    public String getDescricao()  { return estrategia.getDescricao(); }
}