package Comportamentais.visitor;

public class ComboVisitavel implements IElementoCardapio {

    private String nome;
    private double preco;
    private int    calorias;
    private String descricao;

    public ComboVisitavel(String nome, double preco, int calorias, String descricao) {
        this.nome      = nome;
        this.preco     = preco;
        this.calorias  = calorias;
        this.descricao = descricao;
    }

    public String getNome()      { return nome; }
    public double getPreco()     { return preco; }
    public int    getCalorias()  { return calorias; }
    public String getDescricao() { return descricao; }

    @Override
    public void aceitar(IVisitanteCardapio visitante) { visitante.visitar(this); }
}
