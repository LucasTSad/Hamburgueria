package Estrutura.bridge;

public abstract class NotificacaoPedido {

    protected IEnviadorMensagem enviador;

    public NotificacaoPedido(IEnviadorMensagem enviador) {
        this.enviador = enviador;
    }

    public abstract void notificar (String destinatario, String numeroPedido);
}
