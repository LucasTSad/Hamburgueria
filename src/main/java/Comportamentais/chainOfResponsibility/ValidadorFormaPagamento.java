package Comportamentais.chainOfResponsibility;

import java.util.Set;

public class ValidadorFormaPagamento extends ValidadorPedido {

    private static final Set<String> FORMAS_ACEITAS =
            Set.of("dinheiro", "cartao", "pix");

    @Override
    public boolean validar(PedidoRequest pedido) {
        if (!FORMAS_ACEITAS.contains(pedido.getFormaPagamento().toLowerCase())) {
            System.out.println("[VALIDAÇÃO] Forma de pagamento não aceita: "
                    + pedido.getFormaPagamento());
            return false;
        }
        System.out.println("[VALIDAÇÃO] Pagamento OK: " + pedido.getFormaPagamento());
        return repassar(pedido);
    }
}