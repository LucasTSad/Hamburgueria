package Comportamentais.memento;

public class MementoPedido {

    private final String item;
    private final double valor;
    private final String observacao;

    public MementoPedido(String item, double valor, String observacao) {
        this.item       = item;
        this.valor      = valor;
        this.observacao = observacao;
    }

    public String getItem()       { return item; }
    public double getValor()      { return valor; }
    public String getObservacao() { return observacao; }
}