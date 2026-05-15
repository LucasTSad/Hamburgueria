package Criacao.factoryMethod;

import Criacao.singleton.ConfiguracaoHamburgueria;

public class PedidoDelivery implements IPedido {

    private double valorItens;
    private String enderecoEntrega;

    public PedidoDelivery(double valorItens, String enderecoEntrega) {
        this.valorItens = valorItens;
        this.enderecoEntrega = enderecoEntrega;
    }

    @Override
    public void processar() {
        System.out.println("[Delivery] Entrega para: " + enderecoEntrega);
    }

    @Override
    public double calcularTotal() {
        return valorItens + ConfiguracaoHamburgueria.getInstance().getTaxaEntrega();
    }

    @Override
    public String getDescricao() {
        return "Pedido Delivery — entrega em " + enderecoEntrega;
    }
}
