package Criacao.factoryMethod;

public class PedidoFactory {

    public static IPedido criarPedido(String tipo, double valorItens, Object... extras) {
        switch (tipo.toLowerCase()) {
            case "balcao":
                return new PedidoBalcao(valorItens);
            case "delivery":
                String endereco = extras.length > 0 ? (String) extras[0] : "endereço não informado";
                return new PedidoDelivery(valorItens, endereco);
            case "mesa":
                int mesa = extras.length > 0 ? (int) extras[0] : 1;
                return new PedidoMesa(valorItens, mesa);
            default:
                throw new IllegalArgumentException("Tipo de pedido inexistente: " + tipo);
        }
    }
}