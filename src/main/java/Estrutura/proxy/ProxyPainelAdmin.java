package Estrutura.proxy;

import Criacao.singleton.ConfiguracaoHamburgueria;

public class ProxyPainelAdmin implements IPainelAdmin {
    private IPainelAdmin painelReal = new PainelAdminReal();

    private void verificarAcesso() {
        String gerente = ConfiguracaoHamburgueria.getInstance().getGerenteLogado();
        if (gerente == null || gerente.isBlank()) {
            throw new SecurityException("Acesso negado: nenhum gerente logado.");
        }
    }

    @Override
    public void alterarPreco(String item, double novoPreco) {
        verificarAcesso();
        painelReal.alterarPreco(item, novoPreco);
    }

    @Override
    public void fecharCaixa() {
        verificarAcesso();
        painelReal.fecharCaixa();
    }

    @Override
    public void gerarRelatorio() {
        verificarAcesso();
        painelReal.gerarRelatorio();
    }
}