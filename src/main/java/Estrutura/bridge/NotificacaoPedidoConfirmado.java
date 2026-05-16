package Estrutura.bridge;

public class NotificacaoPedidoConfirmado extends NotificacaoPedido {

    public NotificacaoPedidoConfirmado( IEnviadorMensagem enviador) {
        super(enviador);
    }

    @Override
    public void notificar(String destinatario, String numeroPedido) {
        enviador.enviar(destinatario,"Pedido #" + numeroPedido + " confirmado! Já estamos preparando. 🍔");
    }
}
