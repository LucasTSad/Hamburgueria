package Comportamentais.mediator;

public abstract class Setor {

    protected IMediator mediator;
    protected String    nome;

    public Setor(String nome, IMediator mediator) {
        this.nome     = nome;
        this.mediator = mediator;
    }

    public String getNome() { return nome; }

    public abstract void receber(String evento, String dados);
}