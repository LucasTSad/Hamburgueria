package Comportamentais.mediator;

public interface IMediator {
    void notificar(String remetente, String evento, String dados);
}
