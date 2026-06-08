package Comportamentais.observer;

public class ObservadorPainelCozinha implements IObservador {

    private int totalAtualizacoes = 0;

    @Override
    public void atualizar(String numeroPedido, String novoStatus) {
        totalAtualizacoes++;
        System.out.printf("[PAINEL COZINHA] Pedido #%s mudou para %s%n",
                numeroPedido, novoStatus);
    }

    public int getTotalAtualizacoes() { return totalAtualizacoes; }
}