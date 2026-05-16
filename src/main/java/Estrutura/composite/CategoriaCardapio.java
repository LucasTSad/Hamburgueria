package Estrutura.composite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CategoriaCardapio implements IComponenteCardapio {

    private String nome;
    private List<IComponenteCardapio> filhos = new ArrayList<>();

    public CategoriaCardapio(String nome) {

        if(nome == null ) {
            throw new IllegalArgumentException("Nome não pode ser nulo.");
        }
        this.nome = nome;
    }

    public void adicionar(IComponenteCardapio componente) {
        filhos.add(componente);
    }

    public void remover(IComponenteCardapio componente) {
        filhos.remove(componente);
    }

    public List<IComponenteCardapio> getFilhos() {
        return Collections.unmodifiableList(filhos);
    }

    public int totalFilhos() {
        return filhos.size();
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public double getPreco() {
        return filhos.stream().mapToDouble(IComponenteCardapio::getPreco).sum();
    }

    @Override
    public void exibir(String indent) {
        System.out.println(indent + "[" + nome + "]");
        filhos.forEach(f -> f.exibir(indent + "  "));
    }
}
