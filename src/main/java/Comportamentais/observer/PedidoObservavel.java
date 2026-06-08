package Comportamentais.observer;

import java.util.ArrayList;
import java.util.List;

public class PedidoObservavel {

    private String       numeroPedido;
    private String       status;
    private List<IObservador> observadores = new ArrayList<>();

    public PedidoObservavel(String numeroPedido) {
        this.numeroPedido = numeroPedido;
        this.status       = "AGUARDANDO";
    }

    public void adicionarObservador(IObservador obs)  { observadores.add(obs); }
    public void removerObservador(IObservador obs)     { observadores.remove(obs); }
    public int  totalObservadores()                    { return observadores.size(); }

    public void setStatus(String novoStatus) {
        this.status = novoStatus;
        notificarTodos();
    }

    public String getStatus()       { return status; }
    public String getNumeroPedido() { return numeroPedido; }

    private void notificarTodos() {
        observadores.forEach(obs -> obs.atualizar(numeroPedido, status));
    }
}