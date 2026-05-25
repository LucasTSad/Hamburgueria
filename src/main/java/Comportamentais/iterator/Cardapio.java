package Comportamentais.iterator;

import java.util.ArrayList;
import java.util.List;

public class Cardapio {

    private List<ItemMenu> itens = new ArrayList<>();

    public void adicionar(ItemMenu item) { itens.add(item); }
    public int  totalItens()            { return itens.size(); }

    public IIteradorCardapio iterador() {
        return new IteradorCardapio(itens);
    }

    public IIteradorCardapio iteradorPorCategoria(String categoria) {
        return new IteradorCategoria(itens, categoria);
    }
}