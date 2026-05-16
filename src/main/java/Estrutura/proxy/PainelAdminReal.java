package Estrutura.proxy;

public class PainelAdminReal implements  IPainelAdmin {
    @Override
    public void alterarPreco(String item, double novoPreco) {
        System.out.printf("[ADMIN] Preço de '%s' alterado para R$ %.2f%n", item, novoPreco);
    }

    @Override
    public void fecharCaixa() {
        System.out.println("[ADMIN] Caixa fechado. Totais computados.");
    }

    @Override
    public void gerarRelatorio() {
        System.out.println("[ADMIN] Relatório diário gerado.");
    }
}