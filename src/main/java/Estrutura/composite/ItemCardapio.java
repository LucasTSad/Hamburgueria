package Estrutura.composite;

public class ItemCardapio implements IComponenteCardapio {

    private String nome;
    private double preco;

    public ItemCardapio(String nome, double preco) {
        if(nome == null) {
            throw new IllegalArgumentException("Nome não pode ser nulo.");
        } else if (preco < 0) {
            throw new IllegalArgumentException("Preço não pode ser negativo.");
        }
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public double getPreco() {
        return preco;
    }

    @Override
    public void exibir(String indent) {
        System.out.printf("%s- %s .......... R$ %.2f%n", indent, nome, preco);
    }
}
