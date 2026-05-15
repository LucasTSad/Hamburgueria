package Criacao.abstractFactory;

interface Bebida {
    String getDescricao();
    double getPreco();
}

interface Acompanhamento {
    String getDescricao();
    double getPreco();
}

class SucoNatural implements Bebida {
    public String getDescricao() { return "Suco natural de laranja (300ml)"; }
    public double getPreco()     { return 8.00; }
}

class BatataPalito implements Acompanhamento {
    public String getDescricao() { return "Batata palito (porção pequena)"; }
    public double getPreco()     { return 10.00; }
}

class MilkShake implements Bebida {
    public String getDescricao() { return "Milk-shake de chocolate (400ml)"; }
    public double getPreco()     { return 18.00; }
}

class OnionRings implements Acompanhamento {
    public String getDescricao() { return "Onion rings crocantes (6 unid.)"; }
    public double getPreco()     { return 15.00; }
}

public abstract class FabricaCombo {
    public abstract Bebida criarBebida();
    public abstract Acompanhamento criarAcompanhamento();
}

class FabricaComboInfantil extends FabricaCombo {
    public Bebida criarBebida()               { return new SucoNatural(); }
    public Acompanhamento criarAcompanhamento(){ return new BatataPalito(); }
}

class FabricaComboPremium extends FabricaCombo {
    public Bebida criarBebida()               { return new MilkShake(); }
    public Acompanhamento criarAcompanhamento(){ return new OnionRings(); }
}
