package Comportamentais.state;

public class EstadoEmPreparo implements IEstadoPedido {

    @Override
    public void confirmar(PedidoContext ctx) {
        System.out.println("[STATE] Pedido já está em preparo.");
    }

    @Override
    public void preparar(PedidoContext ctx) {
        System.out.println("[STATE] Preparo concluído. Pedido pronto.");
        ctx.setEstado(new EstadoPronto());
    }

    @Override
    public void finalizar(PedidoContext ctx) {
        System.out.println("[STATE] Não é possível finalizar sem estar pronto.");
    }

    @Override public String getNome() { return "EM_PREPARO"; }
}