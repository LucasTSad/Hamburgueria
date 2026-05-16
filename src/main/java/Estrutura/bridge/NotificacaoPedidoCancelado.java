package Estrutura.bridge;

public class NotificacaoPedidoCancelado extends NotificacaoPedidoPronto {

    public NotificacaoPedidoCancelado(IEnviadorMensagem enviador) {
        super(enviador);
    }

    @Override
    public void notificar(String destinatario, String numeroPedido) {
        enviador.enviar(destinatario,
                "Pedido #" + numeroPedido + " cancelado. Entre em contato conosco. ❌");
    }
}
