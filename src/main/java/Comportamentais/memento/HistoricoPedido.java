package Comportamentais.memento;

import java.util.ArrayDeque;
import java.util.Deque;

public class HistoricoPedido {

    private Deque<MementoPedido> pilha = new ArrayDeque<>();

    public void salvar(MementoPedido memento) { pilha.push(memento); }

    public MementoPedido desfazer() {
        if (pilha.isEmpty()) throw new IllegalStateException("Sem histórico para desfazer.");
        return pilha.pop();
    }

    public int totalSalvos() { return pilha.size(); }
}