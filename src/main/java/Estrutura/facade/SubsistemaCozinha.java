package Estrutura.facade;

public class SubsistemaCozinha {
    public void enviarParaProducao(String numeroPedido, String item) {
        System.out.printf("[COZINHA] Preparando pedido #%s: %s%n", numeroPedido, item);
    }
}
