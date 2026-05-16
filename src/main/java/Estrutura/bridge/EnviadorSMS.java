package Estrutura.bridge;

public class EnviadorSMS implements IEnviadorMensagem {

    @Override
    public void enviar(String destinatario, String mensagem) {
        System.out.printf("[SMS → %s] %s%n", destinatario, mensagem);
    }
}
