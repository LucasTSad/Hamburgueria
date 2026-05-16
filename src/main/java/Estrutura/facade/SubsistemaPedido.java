package Estrutura.facade;

public class SubsistemaPedido {
    public String registrar(String cliente, String item) {
        String numero = String.valueOf(System.currentTimeMillis()).substring(8);
        System.out.printf("[PEDIDO] #%s registrado — %s pediu %s%n", numero, cliente, item);
        return numero;
    }
}
