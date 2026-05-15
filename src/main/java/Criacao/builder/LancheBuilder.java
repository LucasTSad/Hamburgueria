package Criacao.builder;

public class LancheBuilder {

    private Lanche lanche;

    public LancheBuilder() {
        lanche = new Lanche();
    }

    public Lanche build() {

        if(lanche.getNome().isEmpty())
            throw new IllegalArgumentException("Nome do lanche é obrigatório.");
        if (lanche.getTipoPao().isEmpty())
            throw new IllegalArgumentException("Tipo de pão é obrigatório.");
        if (lanche.getCarne().isEmpty())
            throw new IllegalArgumentException("Tipo de carne é obrigatório.");
        return lanche;
    }

    public LancheBuilder setNome(String nome) {
        lanche.setNome(nome);
        return  this;
    }

    public LancheBuilder setTipoPao(String tipoPao) {
        lanche.setTipoPao(tipoPao);
        return this;
    }

    public LancheBuilder setCarne(String carne) {
        lanche.setCarne(carne);
        return this;
    }

    public LancheBuilder isQueijo() {
        lanche.setQueijo(true);
        return this;
    }

    public LancheBuilder isBacon() {
        lanche.setBacon(true);
        return this;
    }

    public LancheBuilder isAlface() {
        lanche.setAlface(true);
        return this;
    }

    public LancheBuilder isTomate() {
        lanche.setTomate(true);
        return this;
    }

    public LancheBuilder isPickles() {
        lanche.setPickles(true);
        return this;
    }

    public LancheBuilder isCebola() {
        lanche.setCebola(true);
        return this;
    }

    public  LancheBuilder setMolho(String molho) {
        lanche.setMolho(molho);
        return this;
    }

    public LancheBuilder semGluten() {
        lanche.setSemGluten(true);
        return this;
    }

    public LancheBuilder setPreco(double preco) {
        lanche.setPreco(preco);
        return this;
    }
}
