package Comportamentais.chainOfResponsibility;

public class ValidadorCliente extends ValidadorPedido {

    @Override
    public boolean validar(PedidoRequest pedido) {
        if (pedido.getCliente() == null || pedido.getCliente().isBlank()) {
            System.out.println("[VALIDAÇÃO] Cliente não informado. Pedido bloqueado.");
            return false;
        }
        System.out.println("[VALIDAÇÃO] Cliente OK: " + pedido.getCliente());
        return repassar(pedido);
    }
}