package Estrutura.decorator;

public class LancheSimples implements ILanche {

    private String nome;
    private double preco;

    public LancheSimples(String nome, double preco) {
        if(nome == null) {
            throw new IllegalArgumentException("Nome não pode ser nulo.");
        } else if ( preco < 0 ) {
            throw new IllegalArgumentException("Preço não pode ser negativo.");
        }
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public String getDescricao() {
        return nome;
    }

    @Override
    public double getPreco() {
        return preco;
    }
}
