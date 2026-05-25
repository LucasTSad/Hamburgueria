package Comportamentais.iterator;

import java.util.List;

public class IteradorCardapio implements IIteradorCardapio {

    private List<ItemMenu> itens;
    private int            cursor = 0;

    public IteradorCardapio(List<ItemMenu> itens) { this.itens = itens; }

    @Override public boolean temProximo() { return cursor < itens.size(); }
    @Override public ItemMenu proximo()   { return itens.get(cursor++); }
}
