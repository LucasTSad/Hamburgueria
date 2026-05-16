package Estrutura.adapter;

public class AdapterPagamentoLegado implements IProcessadorPagamento {

    private PagamentoLegado legado;

    public AdapterPagamentoLegado(PagamentoLegado legado) {
        this.legado = legado;
    }

    @Override
    public boolean processarPagamento(String cliente, double valor) {
        int centavos = (int) Math.round(valor * 100);
        int resultado = legado.efetuarCobranca(cliente, centavos);
        return resultado == 0;
    }

    @Override
    public String getFormaPagamento() {
        return "Legado (" + legado.tipoTerminal() + ")";
    }
}
