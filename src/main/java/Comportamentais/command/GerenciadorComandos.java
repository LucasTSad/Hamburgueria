package Comportamentais.command;

import java.util.ArrayDeque;
import java.util.Deque;

public class GerenciadorComandos {

    private Deque<IComando> historico = new ArrayDeque<>();

    public void executar(IComando comando) {
        comando.executar();
        historico.push(comando);
    }

    public void desfazerUltimo() {
        if (!historico.isEmpty()) {
            historico.pop().desfazer();
        } else {
            System.out.println("[GERENCIADOR] Nenhum comando para desfazer.");
        }
    }

    public int totalNoHistorico() { return historico.size(); }
}