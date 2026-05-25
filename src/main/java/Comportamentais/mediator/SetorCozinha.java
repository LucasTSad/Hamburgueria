package Comportamentais.mediator;

public class SetorCozinha extends Setor {

    public SetorCozinha(IMediator mediator) { super("Cozinha", mediator); }

    public void pedidoPronto(String numeroPedido) {
        System.out.println("[COZINHA] Pedido #" + numeroPedido + " pronto.");
        mediator.notificar(nome, "PEDIDO_PRONTO", numeroPedido);
    }

    @Override
    public void receber(String evento, String dados) {
        if ("NOVO_PEDIDO".equals(evento)) {
            System.out.println("[COZINHA] Recebeu novo pedido para preparar: #" + dados);
        }
    }
}