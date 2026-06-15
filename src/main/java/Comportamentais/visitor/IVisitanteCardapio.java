package Comportamentais.visitor;

public interface IVisitanteCardapio {
    void visitar(ItemVisitavel item);
    void visitar(ComboVisitavel combo);
}