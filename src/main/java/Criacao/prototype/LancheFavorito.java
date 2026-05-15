package Criacao.prototype;

import java.util.ArrayList;
import java.util.List;

public class LancheFavorito implements  Cloneable {

    private String nome;
    private String tipoPao;
    private String carne;
    private List<String> ingredientes;
    private String molho;
    private double preco;

    public LancheFavorito(String nome, String tipoPao, String carne, List<String> ingredientes, String molho, double preco) {
        this.nome = nome;
        this.tipoPao = tipoPao;
        this.carne = carne;
        this.ingredientes = ingredientes;
        this.molho = molho;
        this.preco = preco;
    }

    @Override
    public LancheFavorito clone() {
        try {
            LancheFavorito clone = (LancheFavorito) super.clone();
            clone.ingredientes = new ArrayList<>(this.ingredientes);
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoPao() {
        return tipoPao;
    }
    public void setTipoPao(String p) {
        this.tipoPao = p; 
    }

    public String getCarne() {
        return carne; 
    }
    public void setCarne(String c) {
        this.carne = c; 
    }

    public List<String> getIngredientes() {
        return ingredientes; 
    }
    public void adicionarIngrediente(String i) {
        ingredientes.add(i); 
    }
    public void removerIngrediente(String i) {
        ingredientes.remove(i); 
    }

    public String getMolho() {
        return molho; 
    }
    public void setMolho(String m) {
        this.molho = m; 
    }

    public double getPreco() {
        return preco; 
    }
    public void setPreco(double p) {
        this.preco = p; 
    }

    @Override
    public String toString() {
        return String.format("%s [pão %s, %s, molho %s] + %s | R$ %.2f",
                nome, tipoPao, carne, molho, ingredientes, preco);
    }

}
