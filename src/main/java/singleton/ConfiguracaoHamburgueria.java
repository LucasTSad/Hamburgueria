package singleton;

public class ConfiguracaoHamburgueria {

    private ConfiguracaoHamburgueria() {}

    private static ConfiguracaoHamburgueria instance = new ConfiguracaoHamburgueria();

    public static ConfiguracaoHamburgueria getInstance() {
        return instance;
    }

    private String nomeEstabelecimento;
    private double taxaEntrega;
    private String horarioAbertura;
    private String horarioFechamento;
    private String gerenteLogado;

    public String getNomeEstabelecimento() {
        return nomeEstabelecimento;
    }
    public void setNomeEstabelecimento(String nomeEstabelecimento) {
        this.nomeEstabelecimento = nomeEstabelecimento;
    }

    public double getTaxaEntrega() {
        return taxaEntrega;
    }
    public void setTaxaEntrega(double taxaEntrega) {
        this.taxaEntrega = taxaEntrega;
    }

    public String getHorarioAbertura() {
        return horarioAbertura;
    }
    public void setHorarioAbertura(String horarioAbertura) {
        this.horarioAbertura = horarioAbertura;
    }

    public String getHorarioFechamento() {
        return horarioFechamento;
    }
    public void setHorarioFechamento(String horarioFechamento) {
        this.horarioFechamento = horarioFechamento;
    }

    public String getGerenteLogado() {
        return gerenteLogado;
    }
    public void setGerenteLogado(String gerenteLogado) {
        this.gerenteLogado = gerenteLogado;
    }
}
