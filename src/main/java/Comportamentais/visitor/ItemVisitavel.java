package Comportamentais.visitor;

public class ItemVisitavel implements IElementoCardapio {

    private String nome;
    private double preco;
    private int    calorias;

    public ItemVisitavel(String nome, double preco, int calorias) {
        this.nome     = nome;
        this.preco    = preco;
        this.calorias = calorias;
    }

    public String getNome()     { return nome; }
    public double getPreco()    { return preco; }
    public int    getCalorias() { return calorias; }

    @Override
    public void aceitar(IVisitanteCardapio visitante) { visitante.visitar(this); }
}