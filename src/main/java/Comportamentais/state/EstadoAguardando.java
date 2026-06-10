package Comportamentais.state;

public class EstadoAguardando implements IEstadoPedido {

    @Override
    public void confirmar(PedidoContext ctx) {
        System.out.println("[STATE] Pedido confirmado. Indo para preparo.");
        ctx.setEstado(new EstadoEmPreparo());
    }

    @Override
    public void preparar(PedidoContext ctx) {
        System.out.println("[STATE] Pedido ainda não foi confirmado.");
    }

    @Override
    public void finalizar(PedidoContext ctx) {
        System.out.println("[STATE] Não é possível finalizar sem confirmar.");
    }

    @Override public String getNome() { return "AGUARDANDO"; }
}