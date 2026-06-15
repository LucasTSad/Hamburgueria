package Comportamentais.visitor;

public class VisitanteCalculoTotal implements IVisitanteCardapio {

    private double total = 0;

    @Override public void visitar(ItemVisitavel item)   { total += item.getPreco(); }
    @Override public void visitar(ComboVisitavel combo) { total += combo.getPreco(); }

    public double getTotal() { return total; }
}