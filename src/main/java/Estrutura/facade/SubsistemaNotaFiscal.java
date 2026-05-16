package Estrutura.facade;

public class SubsistemaNotaFiscal {
    public void emitir(String numeroPedido, String cliente, double valor) {
        System.out.printf("[NOTA FISCAL] Emitida para %s — pedido #%s — R$ %.2f%n",
                cliente, numeroPedido, valor);
    }
}
