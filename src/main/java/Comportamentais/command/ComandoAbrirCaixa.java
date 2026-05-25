package Comportamentais.command;

public class ComandoAbrirCaixa implements IComando {

    private Caixinha caixa;

    public ComandoAbrirCaixa(Caixinha caixa) { this.caixa = caixa; }

    @Override public void executar()  { caixa.abrir(); }
    @Override public void desfazer() { caixa.fechar(); }
}