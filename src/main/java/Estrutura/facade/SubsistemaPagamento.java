package Estrutura.facade;

public class SubsistemaPagamento {
    public boolean cobrar(String cliente, double valor, String formaPagamento) {
        System.out.printf("[PAGAMENTO] R$ %.2f de %s via %s — aprovado%n",
                valor, cliente, formaPagamento);
        return true;
    }
}
