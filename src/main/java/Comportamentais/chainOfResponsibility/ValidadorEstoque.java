package Comportamentais.chainOfResponsibility;

public class ValidadorEstoque extends ValidadorPedido {

    private static final int LIMITE = 10;

    @Override
    public boolean validar(PedidoRequest pedido) {
        if (pedido.getQuantidadeItens() > LIMITE) {
            System.out.printf("[VALIDAÇÃO] Quantidade %d excede limite de %d.%n",
                    pedido.getQuantidadeItens(), LIMITE);
            return false;
        }
        System.out.println("[VALIDAÇÃO] Estoque OK: " + pedido.getQuantidadeItens());
        return repassar(pedido);
    }
}