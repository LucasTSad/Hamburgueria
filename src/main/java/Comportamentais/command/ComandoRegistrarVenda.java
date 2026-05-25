package Comportamentais.command;

public class ComandoRegistrarVenda implements IComando {

    private Caixinha caixa;
    private double   valor;

    public ComandoRegistrarVenda(Caixinha caixa, double valor) {
        this.caixa = caixa;
        this.valor = valor;
    }

    @Override public void executar()  { caixa.registrarVenda(valor); }
    @Override public void desfazer() { caixa.estornarVenda(valor); }
}