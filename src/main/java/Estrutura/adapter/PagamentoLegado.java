package Estrutura.adapter;

public class PagamentoLegado {

    public int efetuarCobranca(String nomeCliente, int valorEmCentavos){
        System.out.printf("[LEGADO] Cobrando %s — %d centavos%n",nomeCliente, valorEmCentavos);
        return valorEmCentavos > 0 ? 0 : 1;
    }

    public String tipoTerminal() {
        return "TERMINAL_LEGACY_v1";
    }

}