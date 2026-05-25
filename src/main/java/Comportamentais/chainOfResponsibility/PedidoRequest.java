package Comportamentais.chainOfResponsibility;

public class PedidoRequest {

    private String cliente;
    private String item;
    private double valor;
    private String formaPagamento;
    private int    quantidadeItens;

    public PedidoRequest(String cliente, String item, double valor,
                         String formaPagamento, int quantidadeItens) {
        this.cliente         = cliente;
        this.item            = item;
        this.valor           = valor;
        this.formaPagamento  = formaPagamento;
        this.quantidadeItens = quantidadeItens;
    }

    public String getCliente()          { return cliente; }
    public String getItem()             { return item; }
    public double getValor()            { return valor; }
    public String getFormaPagamento()   { return formaPagamento; }
    public int    getQuantidadeItens()  { return quantidadeItens; }
}