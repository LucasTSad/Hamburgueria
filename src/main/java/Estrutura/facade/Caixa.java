package Estrutura.facade;

public class Caixa {

    private SubsistemaPedido pedido = new  SubsistemaPedido();
    private SubsistemaPagamento pagamento = new  SubsistemaPagamento();
    private SubsistemaCozinha cozinha = new  SubsistemaCozinha();
    private SubsistemaNotaFiscal notaFiscal = new  SubsistemaNotaFiscal();

    public  boolean atender (String cliente, String item, double valor, String formaPagamento ) {

        String numeroPedido = pedido.registrar(cliente, item);
        boolean pago = pagamento.cobrar(cliente, valor, formaPagamento);

        if (!pago ) {
            System.out.println("[CAIXA] Pagamento recusado. Pedido cancelado.");
            return false;
        }

        cozinha.enviarParaProducao(numeroPedido, item);
        notaFiscal.emitir(numeroPedido, cliente, valor);
        return true;
    }
}
