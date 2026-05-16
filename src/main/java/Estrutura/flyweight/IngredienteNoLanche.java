package Estrutura.flyweight;

public class IngredienteNoLanche {

    private DadosIngrediente dados;
    private int quantidade;
    private String observacao;

    public IngredienteNoLanche(DadosIngrediente dados, int quantidade, String observacao) {
        this.dados = dados;
        this.quantidade = quantidade;
        this.observacao = observacao;
    }

    public DadosIngrediente getDados() {
        return dados;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String getObservacao() {
        return observacao;
    }

    @Override
    public String toString() {
        return String.format("%s x%d [%s]", dados.getNome(), quantidade, observacao);
    }
}
