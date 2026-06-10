package Comportamentais.state;

public interface IEstadoPedido {
    void confirmar(PedidoContext ctx);
    void preparar(PedidoContext ctx);
    void finalizar(PedidoContext ctx);
    String getNome();
}