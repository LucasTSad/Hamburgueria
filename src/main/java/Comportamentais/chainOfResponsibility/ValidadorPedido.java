package Comportamentais.chainOfResponsibility;

public abstract class ValidadorPedido {

    protected ValidadorPedido proximo;

    public ValidadorPedido setProximo(ValidadorPedido proximo) {
        this.proximo = proximo;
        return proximo;
    }

    public abstract boolean validar(PedidoRequest pedido);

    protected boolean repassar(PedidoRequest pedido) {
        if (proximo != null) return proximo.validar(pedido);
        return true;
    }
}