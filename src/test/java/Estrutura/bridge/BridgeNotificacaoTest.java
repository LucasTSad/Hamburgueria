package Estrutura.bridge;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BridgeNotificacaoTest {

    // -- Combinações abstração + implementação ----------------------------

    @Test
    void notificacaoConfirmadaViaSmsNaoLancaExcecao() {
        NotificacaoPedido notificacao =
                new NotificacaoPedidoConfirmado(new EnviadorSMS());
        assertDoesNotThrow(() -> notificacao.notificar("11999990000", "001"));
    }

    @Test
    void notificacaoConfirmadaViaEmailNaoLancaExcecao() {
        NotificacaoPedido notificacao =
                new NotificacaoPedidoConfirmado(new EnviadorEmail());
        assertDoesNotThrow(() -> notificacao.notificar("cliente@email.com", "001"));
    }

    @Test
    void notificacaoProntoViaSmsNaoLancaExcecao() {
        NotificacaoPedido notificacao =
                new NotificacaoPedidoPronto(new EnviadorSMS());
        assertDoesNotThrow(() -> notificacao.notificar("11999990000", "002"));
    }

    @Test
    void notificacaoCanceladoViaEmailNaoLancaExcecao() {
        NotificacaoPedido notificacao =
                new NotificacaoPedidoCancelado(new EnviadorEmail());
        assertDoesNotThrow(() -> notificacao.notificar("cliente@email.com", "003"));
    }

    // -- Independência entre abstração e implementação --------------------

    @Test
    void mesmaAbstracaoFuncionaComDiferentesImplementacoes() {
        IEnviadorMensagem sms   = new EnviadorSMS();
        IEnviadorMensagem email = new EnviadorEmail();

        NotificacaoPedido viaSms   = new NotificacaoPedidoPronto(sms);
        NotificacaoPedido viaEmail = new NotificacaoPedidoPronto(email);

        assertDoesNotThrow(() -> viaSms.notificar("11999990000", "010"));
        assertDoesNotThrow(() -> viaEmail.notificar("a@b.com", "010"));
    }

    @Test
    void mesmaImplementacaoFuncionaComDiferentesAbstracoes() {
        IEnviadorMensagem sms = new EnviadorSMS();

        NotificacaoPedido confirmado = new NotificacaoPedidoConfirmado(sms);
        NotificacaoPedido pronto     = new NotificacaoPedidoPronto(sms);
        NotificacaoPedido cancelado  = new NotificacaoPedidoCancelado(sms);

        assertDoesNotThrow(() -> confirmado.notificar("11999990000", "020"));
        assertDoesNotThrow(() -> pronto.notificar("11999990000", "021"));
        assertDoesNotThrow(() -> cancelado.notificar("11999990000", "022"));
    }
}