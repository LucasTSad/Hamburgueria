package Comportamentais.observer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ObserverPedidoTest {

    private PedidoObservavel      pedido;
    private ObservadorAppCliente  app;
    private ObservadorPainelCozinha painel;

    @BeforeEach
    void setUp() {
        pedido = new PedidoObservavel("001");
        app    = new ObservadorAppCliente();
        painel = new ObservadorPainelCozinha();
    }

    @Test
    void adicionarObservadorAumentaContagem() {
        pedido.adicionarObservador(app);
        assertEquals(1, pedido.totalObservadores());
    }

    @Test
    void removerObservadorDiminuiContagem() {
        pedido.adicionarObservador(app);
        pedido.removerObservador(app);
        assertEquals(0, pedido.totalObservadores());
    }

    @Test
    void setStatusNotificaObservadorComNovoStatus() {
        pedido.adicionarObservador(app);
        pedido.setStatus("EM_PREPARO");
        assertEquals("EM_PREPARO", app.getUltimoStatus());
    }

    @Test
    void setStatusNotificaTodosOsObservadores() {
        pedido.adicionarObservador(app);
        pedido.adicionarObservador(painel);
        pedido.setStatus("PRONTO");
        assertEquals("PRONTO",    app.getUltimoStatus());
        assertEquals(1, painel.getTotalAtualizacoes());
    }

    @Test
    void duasMudancasDeStatusNotificamDuasVezes() {
        pedido.adicionarObservador(painel);
        pedido.setStatus("EM_PREPARO");
        pedido.setStatus("PRONTO");
        assertEquals(2, painel.getTotalAtualizacoes());
    }

    @Test
    void observadorRemovidoNaoRecebeNotificacao() {
        pedido.adicionarObservador(app);
        pedido.removerObservador(app);
        pedido.setStatus("PRONTO");
        assertNull(app.getUltimoStatus());
    }

    @Test
    void statusInicialEhAguardando() {
        assertEquals("AGUARDANDO", pedido.getStatus());
    }

    @Test
    void numeroPedidoEhArmazenadoCorretamente() {
        assertEquals("001", pedido.getNumeroPedido());
    }
}