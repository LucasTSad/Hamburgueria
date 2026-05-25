package Comportamentais.memento;

public class PedidoEmEdicao {

    private String item;
    private double valor;
    private String observacao;

    public PedidoEmEdicao(String item, double valor, String observacao) {
        this.item       = item;
        this.valor      = valor;
        this.observacao = observacao;
    }

    public MementoPedido salvar() {
        return new MementoPedido(item, valor, observacao);
    }

    public void restaurar(MementoPedido memento) {
        this.item       = memento.getItem();
        this.valor      = memento.getValor();
        this.observacao = memento.getObservacao();
    }

    public String getItem()        { return item; }
    public double getValor()       { return valor; }
    public String getObservacao()  { return observacao; }

    public void setItem(String item)            { this.item = item; }
    public void setValor(double valor)          { this.valor = valor; }
    public void setObservacao(String obs)       { this.observacao = obs; }
}