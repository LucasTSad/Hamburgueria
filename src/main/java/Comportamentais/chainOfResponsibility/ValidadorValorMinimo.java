package Comportamentais.chainOfResponsibility;

public class ValidadorValorMinimo extends ValidadorPedido {

    private static final double VALOR_MINIMO = 20.00;

    @Override
    public boolean validar(PedidoRequest pedido) {
        if (pedido.getValor() < VALOR_MINIMO) {
            System.out.printf("[VALIDAÇÃO] Valor R$ %.2f abaixo do mínimo R$ %.2f.%n",
                    pedido.getValor(), VALOR_MINIMO);
            return false;
        }
        System.out.println("[VALIDAÇÃO] Valor OK: R$ " + pedido.getValor());
        return repassar(pedido);
    }
}