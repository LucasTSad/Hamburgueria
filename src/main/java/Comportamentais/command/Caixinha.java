package Comportamentais.command;

public class Caixinha {

    private double totalVendas  = 0;
    private boolean aberto      = false;

    public void abrir()  { aberto = true;  System.out.println("[CAIXA] Aberto."); }
    public void fechar() { aberto = false; System.out.println("[CAIXA] Fechado."); }

    public void registrarVenda(double valor) {
        totalVendas += valor;
        System.out.printf("[CAIXA] Venda de R$ %.2f registrada. Total: R$ %.2f%n",
                valor, totalVendas);
    }

    public void estornarVenda(double valor) {
        totalVendas -= valor;
        System.out.printf("[CAIXA] Estorno de R$ %.2f. Total: R$ %.2f%n",
                valor, totalVendas);
    }

    public double getTotalVendas() { return totalVendas; }
    public boolean isAberto()      { return aberto; }
}