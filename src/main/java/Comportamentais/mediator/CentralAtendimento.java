package Comportamentais.mediator;

public class CentralAtendimento implements IMediator {

    private SetorCozinha    cozinha;
    private SetorEntrega    entrega;
    private SetorAtendimento atendimento;

    public void setCozinha(SetorCozinha cozinha)          { this.cozinha     = cozinha; }
    public void setEntrega(SetorEntrega entrega)          { this.entrega     = entrega; }
    public void setAtendimento(SetorAtendimento atend)    { this.atendimento = atend; }

    @Override
    public void notificar(String remetente, String evento, String dados) {
        switch (evento) {
            case "NOVO_PEDIDO":
                if (cozinha != null) cozinha.receber(evento, dados);
                break;
            case "PEDIDO_PRONTO":
                if (entrega != null) entrega.receber(evento, dados);
                break;
            case "PEDIDO_ENTREGUE":
                if (atendimento != null) atendimento.receber(evento, dados);
                break;
        }
    }
}