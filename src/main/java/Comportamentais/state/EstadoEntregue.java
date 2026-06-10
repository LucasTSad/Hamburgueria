package Comportamentais.state;

public class EstadoEntregue implements IEstadoPedido {

    @Override public void confirmar(PedidoContext ctx) { System.out.println("[STATE] Pedido já encerrado."); }
    @Override public void preparar(PedidoContext ctx)  { System.out.println("[STATE] Pedido já encerrado."); }
    @Override public void finalizar(PedidoContext ctx) { System.out.println("[STATE] Pedido já encerrado."); }
    @Override public String getNome()                  { return "ENTREGUE"; }
}