package Comportamentais.mediator;

public class SetorAtendimento extends Setor {

    public SetorAtendimento(IMediator mediator) { super("Atendimento", mediator); }

    public void registrarPedido(String numeroPedido) {
        System.out.println("[ATENDIMENTO] Pedido #" + numeroPedido + " registrado.");
        mediator.notificar(nome, "NOVO_PEDIDO", numeroPedido);
    }

    @Override
    public void receber(String evento, String dados) {
        if ("PEDIDO_ENTREGUE".equals(evento)) {
            System.out.println("[ATENDIMENTO] Pedido #" + dados + " finalizado. Cliente notificado.");
        }
    }
}
