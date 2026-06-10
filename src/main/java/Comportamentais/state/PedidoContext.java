package Comportamentais.state;

public class PedidoContext {

    private IEstadoPedido estado;

    public PedidoContext() {
        this.estado = new EstadoAguardando();
    }

    public void setEstado(IEstadoPedido estado) { this.estado = estado; }
    public IEstadoPedido getEstado()            { return estado; }
    public String getStatusAtual()             { return estado.getNome(); }

    public void confirmar() { estado.confirmar(this); }
    public void preparar()  { estado.preparar(this); }
    public void finalizar() { estado.finalizar(this); }
}