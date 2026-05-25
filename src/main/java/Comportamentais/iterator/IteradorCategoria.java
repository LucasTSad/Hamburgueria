package Comportamentais.iterator;

import java.util.List;
import java.util.stream.Collectors;

public class IteradorCategoria implements IIteradorCardapio {

    private List<ItemMenu> itensFiltrados;
    private int            cursor = 0;

    public IteradorCategoria(List<ItemMenu> todos, String categoria) {
        this.itensFiltrados = todos.stream()
                .filter(i -> i.getCategoria().equalsIgnoreCase(categoria))
                .collect(Collectors.toList());
    }

    @Override public boolean temProximo() { return cursor < itensFiltrados.size(); }
    @Override public ItemMenu proximo()   { return itensFiltrados.get(cursor++); }
}