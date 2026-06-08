package Comportamentais.observer;

public class ObservadorAppCliente implements IObservador {

    private String ultimoStatus;

    @Override
    public void atualizar(String numeroPedido, String novoStatus) {
        this.ultimoStatus = novoStatus;
        System.out.printf("[APP] Pedido #%s → %s%n", numeroPedido, novoStatus);
    }

    public String getUltimoStatus() { return ultimoStatus; }
}