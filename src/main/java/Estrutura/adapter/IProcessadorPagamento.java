package Estrutura.adapter;

public interface IProcessadorPagamento {
    boolean processarPagamento(String cliente, double valor);
    String getFormaPagamento();
}
