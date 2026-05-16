package Estrutura.bridge;

public class EnviadorEmail implements IEnviadorMensagem {

    @Override
    public void enviar(String destinatario, String mensagem) {
        System.out.printf("[E-MAIL → %s] %s%n", destinatario, mensagem);
    }
}
