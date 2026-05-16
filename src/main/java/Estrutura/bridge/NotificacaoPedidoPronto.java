package Estrutura.bridge;

public class NotificacaoPedidoPronto extends NotificacaoPedido {

    public NotificacaoPedidoPronto (IEnviadorMensagem enviador) {
        super(enviador);
    }

    @Override
    public void notificar(String destinatario, String numeroPedido) {
        enviador.enviar(destinatario,"Pedido #" + numeroPedido + " pronto! Pode retirar no balcão. ✅");
    }
}
