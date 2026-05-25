package Comportamentais.mediator;

public class SetorEntrega extends Setor {

    public SetorEntrega(IMediator mediator) { super("Entrega", mediator); }

    public void pedidoEntregue(String numeroPedido) {
        System.out.println("[ENTREGA] Pedido #" + numeroPedido + " entregue.");
        mediator.notificar(nome, "PEDIDO_ENTREGUE", numeroPedido);
    }

    @Override
    public void receber(String evento, String dados) {
        if ("PEDIDO_PRONTO".equals(evento)) {
            System.out.println("[ENTREGA] Saindo para entregar pedido #" + dados);
        }
    }
}