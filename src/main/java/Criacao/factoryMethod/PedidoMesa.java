package Criacao.factoryMethod;

public class PedidoMesa implements IPedido {

    private double valorItens;
    private int numeroMesa;

    public PedidoMesa( double valorItens, int numeroMesa) {
        this.valorItens = valorItens;
        this.numeroMesa = numeroMesa;
    }

    @Override
    public void processar() {
        System.out.println("[Mesa " + numeroMesa + "] Pedido anotado pelo garçom.");
    }

    @Override
    public double calcularTotal() {
        return valorItens * 1.10;
    }

    @Override
    public String getDescricao() {
        return "Pedido Mesa " + numeroMesa + " (inclui 10% serviço)";
    }
}
