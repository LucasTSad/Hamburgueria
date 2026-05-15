package Criacao.builder;

import java.util.List;
import java.util.ArrayList;

public class Lanche {

    private String nome;
    private String tipoPao;
    private String carne;
    private String molho;
    private boolean queijo;
    private boolean bacon;
    private boolean alface;
    private boolean tomate;
    private boolean cebola;
    private boolean pickles;
    private boolean semGluten;
    private double preco;

    Lanche() {
        this.nome = "";
        this.tipoPao = "";
        this.carne = "";
        this.molho = "";
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
    public void setTipoPao(String tipoPao) {
        this.tipoPao = tipoPao;
    }

    public String getCarne() {
        return carne;
    }
    public void setCarne(String carne) {
        this.carne = carne;
    }

    public String getMolho() {
        return molho;
    }
    public void setMolho(String molho) {
        this.molho = molho;
    }

    public boolean isQueijo() {
        return queijo;
    }
    public void setQueijo(boolean queijo) {
        this.queijo = queijo;
    }

    public boolean isBacon() {
        return bacon;
    }
    public void setBacon(boolean bacon) {
        this.bacon = bacon;
    }

    public boolean isAlface() {
        return alface;
    }
    public void setAlface(boolean alface) {
        this.alface = alface;
    }

    public boolean isTomate() {
        return tomate;
    }
    public void setTomate(boolean tomate) {
        this.tomate = tomate;
    }

    public boolean isCebola() {
        return cebola;
    }
    public void setCebola(boolean cebola) {
        this.cebola = cebola;
    }

    public boolean isPickles() {
        return pickles;
    }
    public void setPickles(boolean pickles) {
        this.pickles = pickles;
    }

    public boolean isSemGluten() {
        return semGluten;
    }
    public void setSemGluten(boolean semGluten) {
        this.semGluten = semGluten;
    }

    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {

        List<String> ingredientes = new ArrayList<>();
        if (queijo)  ingredientes.add("Queijo");
        if (bacon)  ingredientes.add("Bacon");
        if (tomate)  ingredientes.add("Tomate");
        if (cebola)  ingredientes.add("Celbola");
        if (pickles)  ingredientes.add("Pickles");
        if (!molho.isEmpty())  ingredientes.add("Molho" + molho);

        return String.format("%s [pão %s, %s%s] + %s | R$ %.2f",
                nome, tipoPao, carne,
                semGluten ? " (sem glútem)" : "",
                String.join(", ", ingredientes),
                preco);
    }
}

