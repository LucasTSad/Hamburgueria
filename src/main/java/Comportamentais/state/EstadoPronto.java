package Comportamentais.state;

public class EstadoPronto implements IEstadoPedido {

    @Override
    public void confirmar(PedidoContext ctx) {
        System.out.println("[STATE] Pedido já está pronto.");
    }

    @Override
    public void preparar(PedidoContext ctx) {
        System.out.println("[STATE] Pedido já foi preparado.");
    }

    @Override
    public void finalizar(PedidoContext ctx) {
        System.out.println("[STATE] Pedido entregue ao cliente.");
        ctx.setEstado(new EstadoEntregue());
    }

    @Override public String getNome() { return "PRONTO"; }
}