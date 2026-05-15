package Criacao.factoryMethod;

public class PedidoBalcao implements IPedido {

    private double valorItens;

    public PedidoBalcao(double valorItens) {
        this.valorItens = valorItens;
    }

    @Override
    public void processar() {
        System.out.println("[Balcão] Pedido enviado direto para a cozinha.");
    }

    @Override
    public double calcularTotal() {
        return valorItens;
    }

    @Override
    public String getDescricao() {
        return "Pedido Balcão — retirada no local";
    }
}
