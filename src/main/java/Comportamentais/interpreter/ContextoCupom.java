package Comportamentais.interpreter;

public class ContextoCupom {

    private double valorPedido;
    private double taxaEntrega;

    public ContextoCupom(double valorPedido, double taxaEntrega) {
        this.valorPedido  = valorPedido;
        this.taxaEntrega  = taxaEntrega;
    }

    public double getValorPedido()  { return valorPedido; }
    public double getTaxaEntrega()  { return taxaEntrega; }
}